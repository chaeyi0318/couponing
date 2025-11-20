package com.project.couponing.coupon.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponIssueJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public void insertIssue(Long id, Long eventId, String requestId) {
        String sql = "INSERT INTO COUPON_ISSUE (USER_ID, EVENT_ID, REQUEST_ID)" +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id, eventId, requestId);
    }
}
