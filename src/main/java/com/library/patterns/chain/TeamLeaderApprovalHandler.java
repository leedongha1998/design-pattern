package com.library.patterns.chain;

/**
 * 팀장 승인 단계입니다.
 */
public class TeamLeaderApprovalHandler extends ApprovalHandler {

    @Override
    protected boolean canApprove(ApprovalRequest request) {
        return request.amount() <= 500_000;
    }

    @Override
    protected String approver() {
        return "TEAM_LEADER";
    }

    @Override
    protected String approveMessage(ApprovalRequest request) {
        return "팀장 승인(" + request.amount() + "원)";
    }

    @Override
    protected String rejectMessage(ApprovalRequest request) {
        return "팀장 승인 불가(" + request.amount() + "원): 금액 초과";
    }
}
