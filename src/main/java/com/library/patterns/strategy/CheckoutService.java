package com.library.patterns.strategy;

import org.springframework.stereotype.Component;

/**
 * 결제 전략을 사용하는 컨텍스트(Context) 클래스입니다.
 *
 * <p>전략 객체만 바꿔주면 서비스 내부 코드를 바꾸지 않고
 * 다양한 결제 정책을 적용할 수 있습니다.
 */
@Component
public class CheckoutService {

    /**
     * 전달받은 전략으로 결제를 수행합니다.
     */
    public String checkout(int amount, PaymentStrategy strategy) {
        return strategy.pay(amount);
    }
}
