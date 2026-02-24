package com.library.patterns.strategy;

import java.math.BigDecimal;

/**
 * 실무형 결제 요청 모델입니다.
 */
public record PaymentRequest(
        String orderId,
        String customerId,
        BigDecimal amount,
        String currency,
        boolean firstOrder,
        int loyaltyTier,
        String idempotencyKey
) {
}
