package com.library.patterns.observer;

import java.time.Instant;

/**
 * 주문 도메인 이벤트 모델.
 */
public record OrderEvent(
        String orderNo,
        String status,
        String actor,
        Instant occurredAt
) {
}
