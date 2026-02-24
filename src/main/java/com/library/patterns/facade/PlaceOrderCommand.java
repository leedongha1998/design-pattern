package com.library.patterns.facade;

/**
 * 주문 생성 명령.
 */
public record PlaceOrderCommand(
        String orderNo,
        String productId,
        int amount,
        String customerId,
        String traceId
) {
}
