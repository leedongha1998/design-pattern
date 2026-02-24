package com.library.patterns.facade;

/**
 * 결제 처리 서브 시스템입니다.
 */
public class BillingService {

    public String charge(String orderNo, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("결제 금액이 올바르지 않습니다");
        }
        if (amount >= 5_000_000) {
            throw new IllegalStateException("결제 한도 초과");
        }
        return "결제 완료(" + orderNo + ", " + amount + "원)";
    }
}
