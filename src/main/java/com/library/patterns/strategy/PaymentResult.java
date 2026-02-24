package com.library.patterns.strategy;

import java.math.BigDecimal;

/**
 * 결제 처리 결과입니다.
 */
public record PaymentResult(
        String provider,
        boolean approved,
        BigDecimal chargedAmount,
        BigDecimal fee,
        String message,
        String traceId
) {
}
