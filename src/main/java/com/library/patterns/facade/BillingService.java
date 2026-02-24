package com.library.patterns.facade;

/**
 * 결제 처리 서브 시스템입니다.
 */
public class BillingService {

    public String charge(String orderNo, int amount) {
        return "결제 완료(" + orderNo + ", " + amount + "원)";
    }
}
