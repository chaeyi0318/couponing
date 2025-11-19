package com.project.couponing.coupon.controller;

import com.project.couponing.common.ApiSuccess;
import com.project.couponing.coupon.service.CouponIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class CouponIssueController {
    private final CouponIssueService couponIssueService;

    @PostMapping("/{eventId}/coupon")
    public ResponseEntity<ApiSuccess> issueCoupon(@PathVariable Long eventId,
                                                  @RequestHeader("X-User-Id") Long userId,
                                                  @RequestHeader("X-Request-Id") String requestId) {
        return couponIssueService.issueCoupon(eventId, userId, requestId);
    }
}
