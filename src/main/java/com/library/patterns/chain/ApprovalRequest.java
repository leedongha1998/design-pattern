package com.library.patterns.chain;

/**
 * 승인 요청 모델.
 */
public record ApprovalRequest(
        String requestId,
        String requesterRole,
        String department,
        int amount,
        String traceId
) {
}
