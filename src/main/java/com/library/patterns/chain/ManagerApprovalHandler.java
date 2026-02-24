package com.library.patterns.chain;

/**
 * 부서장 승인 단계입니다.
 */
public class ManagerApprovalHandler extends ApprovalHandler {

    @Override
    protected boolean canApprove(ApprovalRequest request) {
        return request.amount() <= 2_000_000;
    }

    @Override
    protected String approver() {
        return "MANAGER";
    }

    @Override
    protected String approveMessage(ApprovalRequest request) {
        return "부서장 승인(" + request.amount() + "원)";
    }

    @Override
    protected String rejectMessage(ApprovalRequest request) {
        return "부서장 승인 불가(" + request.amount() + "원): 금액 초과";
    }
}
