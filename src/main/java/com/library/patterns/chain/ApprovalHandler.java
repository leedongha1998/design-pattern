package com.library.patterns.chain;

/**
 * Chain of Responsibility 패턴의 공통 핸들러입니다.
 */
public abstract class ApprovalHandler {

    private ApprovalHandler next;

    public ApprovalHandler linkWith(ApprovalHandler next) {
        this.next = next;
        return next;
    }

    public final ApprovalDecision handle(ApprovalRequest request) {
        long startedAt = System.currentTimeMillis();

        if (canApprove(request)) {
            return new ApprovalDecision(
                    true,
                    approver(),
                    approveMessage(request),
                    "",
                    false,
                    System.currentTimeMillis() - startedAt,
                    request.traceId()
            );
        }

        if (next != null) {
            return next.handle(request);
        }

        return new ApprovalDecision(
                false,
                approver(),
                rejectMessage(request),
                "LIMIT_EXCEEDED",
                false,
                System.currentTimeMillis() - startedAt,
                request.traceId()
        );
    }

    protected abstract boolean canApprove(ApprovalRequest request);

    protected abstract String approver();

    protected abstract String approveMessage(ApprovalRequest request);

    protected abstract String rejectMessage(ApprovalRequest request);
}
