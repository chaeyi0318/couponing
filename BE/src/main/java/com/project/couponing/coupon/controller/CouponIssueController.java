package com.project.couponing.coupon.controller;

import com.project.couponing.coupon.service.CouponIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class CouponIssueController {
    private final CouponIssueService couponIssueService;

}
