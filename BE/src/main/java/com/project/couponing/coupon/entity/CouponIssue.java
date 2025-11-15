package com.project.couponing.coupon.entity;

import com.project.couponing.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_issue_user_event",
                columnNames = {"user_id", "event_id"}),
        @UniqueConstraint(
                name = "uk_issue_request_id",
                columnNames = {"request_id"})
    }
)       // 한 유저가 같은 이벤트에서 쿠폰을 한 번만 받을 수 있도록 제약
@Getter
@NoArgsConstructor
public class CouponIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestId;       // idempotency 보장용 (중복 요청 구분용)

    private LocalDateTime createdAt;        // 발급 시간

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;      // 누가

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private CouponEvent event;      // 어떤 이벤트에서
}
