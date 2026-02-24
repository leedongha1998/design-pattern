package com.library.patterns.chain;

/**
 * 승인 의사결정 결과.
 */
public record ApprovalDecision(
        boolean approved,
        String approver,
        String reason,
        String errorCode,
        boolean retryable,
        long latencyMs,
        String traceId
) {
}
