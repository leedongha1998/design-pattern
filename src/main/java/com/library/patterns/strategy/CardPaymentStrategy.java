package com.library.patterns.strategy;

/**
 * 신용카드 결제 전략입니다.
 */
public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "신용카드로 " + amount + "원 결제 완료";
    }
}
