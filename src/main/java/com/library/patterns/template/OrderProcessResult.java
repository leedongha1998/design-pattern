package com.library.patterns.template;

import java.util.List;

/**
 * 주문 템플릿 처리 결과.
 */
public record OrderProcessResult(
        String orderNo,
        String traceId,
        boolean success,
        String errorCode,
        boolean retryable,
        long totalLatencyMs,
        List<TemplateStepResult> steps
) {
}
