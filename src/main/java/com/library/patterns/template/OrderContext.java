package com.library.patterns.template;

import java.math.BigDecimal;

/**
 * 템플릿 처리용 주문 컨텍스트.
 */
public record OrderContext(
        String orderNo,
        String customerId,
        BigDecimal amount,
        String channel,
        String traceId
) {
}
