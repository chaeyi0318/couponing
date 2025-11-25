package com.project.couponing.coupon.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponIssueJdbcRepository {
    // JPA는 오버헤드가 크고 느리기 때문에 JDBC 사용
    // - JPA는 동시성 경쟁 때 select를 추가로 발생해서 병목이 생김 바로 insert가 가능한 JDBC를 사용함
    // - 이 때 중복 발급 방지를 위해 unique 제약을 걸어줌
    private final JdbcTemplate jdbcTemplate;

    public void insertIssue(Long id, Long eventId, String requestId) {
        String sql = "INSERT INTO COUPON_ISSUE (USER_ID, EVENT_ID, REQUEST_ID)" +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id, eventId, requestId);
    }
}
