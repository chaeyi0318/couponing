package com.project.couponing.coupon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final StringRedisTemplate redisTemplate;

    //  redis 키
    private String stockKey (Long eventId) {
        return "stock:event:" + eventId;
    }

    // 재고조회
    public int getStock(Long eventId) {
        String value = redisTemplate.opsForValue().get(stockKey(eventId));

        return value != null ? Integer.parseInt(value) : 0;
    }

    // 재고차감
    // redis는 한 번에 한 명만 감소시키도록 알아서 처리해줌
    // 재고 이상으로 발급 되는 경우를 막기 위해 사용
    public boolean decreaseStock(Long eventId) {
        Long result = redisTemplate.opsForValue().decrement(stockKey(eventId));

//        System.out.println("DECR " + stockKey(eventId) + " -> " + result);
        return result != null && result >= 0;
    }
}
