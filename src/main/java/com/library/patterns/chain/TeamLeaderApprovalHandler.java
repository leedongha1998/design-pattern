package com.library.patterns.chain;

/**
 * 팀장 승인 단계입니다.
 */
public class TeamLeaderApprovalHandler extends ApprovalHandler {

    @Override
    protected boolean canApprove(int amount) {
        return amount <= 500_000;
    }

    @Override
    protected String approveMessage(int amount) {
        return "팀장 승인(" + amount + "원)";
    }

    @Override
    protected String rejectMessage(int amount) {
        return "팀장 승인 불가(" + amount + "원): 금액 초과";
    }
}
