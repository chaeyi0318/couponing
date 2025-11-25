package com.project.couponing.coupon.service;

import com.project.couponing.common.ApiErrorCode;
import com.project.couponing.common.ApiException;
import com.project.couponing.common.ApiSuccess;
import com.project.couponing.coupon.repository.CouponEventRepository;
import com.project.couponing.coupon.repository.CouponIssueJdbcRepository;
import com.project.couponing.coupon.repository.CouponIssueRepository;
import com.project.couponing.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponIssueService {
    private final CouponEventRepository couponEventRepository;
    private final CouponIssueJdbcRepository couponIssueJdbcRepository;
    private final RedisService redisService;

    private final UserService userService;

    public ResponseEntity<ApiSuccess> issueCoupon(Long eventId, Long userId, String requestId) {
        // 해당 쿠폰이 존재하지 않는 경우
        if (!couponEventRepository.existsById(eventId)) {
            throw new ApiException(ApiErrorCode.EVENT_NOT_FOUND);
        }

        // 유저 검증
        userService.validateUserExists(userId);

        // 멱등키 사용해서 쿠폰 발급
        // 멱등키 검증 (같은 요청이 들어와도 한 번만 처리하기 위한 단계)
        // redis에서는 재고만 관리하고 어떤 요청을 처리했는 지 기록하는 부분이 없기 때문에 DB에서 체크함
        if (requestId == null || requestId.isEmpty()) {
            throw new ApiException(ApiErrorCode.INVALID_REQUEST);
        }

        // 재고 체크
        // 재고 하나 감소
        if (!redisService.decreaseStock(eventId)) {
            throw new ApiException(ApiErrorCode.NO_STOCK);
        }

        try {
            couponIssueJdbcRepository.insertIssue(userId, eventId, requestId);
        } catch (DuplicateKeyException e) {
            // userId, eventId 유니크 위반, requestId 유니크 위반
            // 둘 다 이미 처리된 요청으로 봄
            throw new ApiException(ApiErrorCode.ALREADY_ISSUED);
        }

        return ResponseEntity.ok(ApiSuccess.ok("쿠폰 발급 성공"));
    }
}
