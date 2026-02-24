package com.library.patterns.chain;

/**
 * Chain of Responsibility 패턴의 공통 핸들러입니다.
 */
public abstract class ApprovalHandler {

    private ApprovalHandler next;

    /**
     * 다음 처리자 연결 메서드(체이닝 가능).
     */
    public ApprovalHandler linkWith(ApprovalHandler next) {
        this.next = next;
        return next;
    }

    public final String handle(int amount) {
        if (!canApprove(amount)) {
            return rejectMessage(amount);
        }

        if (next == null) {
            return approveMessage(amount);
        }

        return approveMessage(amount) + " -> " + next.handle(amount);
    }

    protected abstract boolean canApprove(int amount);

    protected abstract String approveMessage(int amount);

    protected abstract String rejectMessage(int amount);
}
