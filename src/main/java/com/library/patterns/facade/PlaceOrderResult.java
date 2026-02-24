package com.library.patterns.facade;

import java.util.List;

/**
 * 주문 처리 결과.
 */
public record PlaceOrderResult(
        boolean success,
        String orderNo,
        String traceId,
        String failedAt,
        String errorCode,
        boolean retryable,
        long totalLatencyMs,
        List<FacadeStepResult> steps
) {
}
