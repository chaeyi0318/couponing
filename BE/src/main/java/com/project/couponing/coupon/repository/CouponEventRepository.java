package com.project.couponing.coupon.repository;

import com.project.couponing.coupon.entity.CouponEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponEventRepository extends JpaRepository<CouponEvent, Long> {
}
