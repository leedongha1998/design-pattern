package com.library.patterns.chain;

/**
 * 임원 승인 단계입니다.
 */
public class DirectorApprovalHandler extends ApprovalHandler {

    @Override
    protected boolean canApprove(ApprovalRequest request) {
        return request.amount() <= 10_000_000;
    }

    @Override
    protected String approver() {
        return "DIRECTOR";
    }

    @Override
    protected String approveMessage(ApprovalRequest request) {
        return "임원 승인(" + request.amount() + "원)";
    }

    @Override
    protected String rejectMessage(ApprovalRequest request) {
        return "임원 승인 불가(" + request.amount() + "원): 한도 초과";
    }
}
