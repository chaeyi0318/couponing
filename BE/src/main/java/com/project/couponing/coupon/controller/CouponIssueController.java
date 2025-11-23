package com.project.couponing.coupon.controller;

import com.project.couponing.common.ApiSuccess;
import com.project.couponing.coupon.service.CouponIssueService;
import com.project.couponing.coupon.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class CouponIssueController {
    private final CouponIssueService couponIssueService;
    private final RedisService redisService;

    // 쿠폰 발급
    @PostMapping("/{eventId}/coupon")
    public ResponseEntity<ApiSuccess> issueCoupon(@PathVariable Long eventId,
                                                  @RequestHeader("X-User-Id") Long userId,
                                                  @RequestHeader("X-Request-Id") String requestId) {
        return couponIssueService.issueCoupon(eventId, userId, requestId);
    }

    // 재고 조회
    @GetMapping("/{eventId}/stock")
    public int getStock(@PathVariable Long eventId) {
        return redisService.getStock(eventId);
    }
}
