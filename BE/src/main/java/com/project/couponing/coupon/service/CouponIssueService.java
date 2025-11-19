package com.project.couponing.coupon.service;

import com.project.couponing.coupon.repository.CouponIssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponIssueService {
    private final CouponIssueRepository couponIssueRepository;
}
