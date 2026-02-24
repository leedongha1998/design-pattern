package com.library.patterns.chain;

/**
 * 임원 승인 단계입니다.
 */
public class DirectorApprovalHandler extends ApprovalHandler {

    @Override
    protected boolean canApprove(int amount) {
        return amount <= 10_000_000;
    }

    @Override
    protected String approveMessage(int amount) {
        return "임원 승인(" + amount + "원)";
    }

    @Override
    protected String rejectMessage(int amount) {
        return "임원 승인 불가(" + amount + "원): 한도 초과";
    }
}
