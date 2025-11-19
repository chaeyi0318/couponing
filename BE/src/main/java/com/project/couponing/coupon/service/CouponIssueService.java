package com.project.couponing.coupon.service;

import com.project.couponing.common.ApiErrorCode;
import com.project.couponing.common.ApiException;
import com.project.couponing.common.ApiSuccess;
import com.project.couponing.coupon.repository.CouponIssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponIssueService {
    private final CouponIssueRepository couponIssueRepository;

    public ResponseEntity<ApiSuccess> issueCoupon(Long eventId, Long userId, String requestId) {
        // 해당 쿠폰이 존재하지 않는 경우
        if (!couponIssueRepository.existsById(eventId)) {
            throw new ApiException(ApiErrorCode.EVENT_NOT_FOUND, ApiErrorCode.EVENT_NOT_FOUND.getMessage());
        }

        return null;
    }
}
