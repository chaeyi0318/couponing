package com.project.couponing.coupon.entity;

import com.project.couponing.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "event_id"}),
        @UniqueConstraint(columnNames = {"request_id"})
    }
)       // 한 유저가 같은 이벤트에서 쿠폰을 한 번만 받을 수 있도록 제약
public class CouponIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestId;       // idempotency 보장용

    private LocalDateTime createdAt;        // 발급 시간

    @ManyToOne
    private User user;

    @ManyToOne
    private CouponEvent event;

}
