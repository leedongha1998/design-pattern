package com.library.patterns.strategy;

/**
 * 간편결제(카카오페이) 전략입니다.
 */
public class KakaoPayStrategy implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "카카오페이로 " + amount + "원 결제 완료";
    }
}
