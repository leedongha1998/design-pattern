package com.library.patterns.chain;

/**
 * 부서장 승인 단계입니다.
 */
public class ManagerApprovalHandler extends ApprovalHandler {

    @Override
    protected boolean canApprove(int amount) {
        return amount <= 2_000_000;
    }

    @Override
    protected String approveMessage(int amount) {
        return "부서장 승인(" + amount + "원)";
    }

    @Override
    protected String rejectMessage(int amount) {
        return "부서장 승인 불가(" + amount + "원): 금액 초과";
    }
}
