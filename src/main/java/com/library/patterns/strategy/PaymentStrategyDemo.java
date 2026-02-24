package com.library.patterns.strategy;

import org.springframework.stereotype.Component;

/**
 * Strategy 패턴 동작을 콘솔로 보여주는 데모 클래스입니다.
 */
@Component
public class PaymentStrategyDemo {

    private final CheckoutService checkoutService;

    public PaymentStrategyDemo(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    public void run() {
        System.out.println(checkoutService.checkout(12000, new CardPaymentStrategy()));
        System.out.println(checkoutService.checkout(8500, new KakaoPayStrategy()));
    }
}
