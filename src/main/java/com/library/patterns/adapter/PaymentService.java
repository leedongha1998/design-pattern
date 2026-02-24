package com.library.patterns.adapter;

import org.springframework.stereotype.Component;

/**
 * 신규 결제 서비스입니다.
 *
 * <p>구현체 타입이 아니라 PaymentPort에만 의존하므로
 * 레거시/신규 구현 교체가 쉬워집니다.
 */
@Component
public class PaymentService {

    public String pay(int amount, PaymentPort paymentPort) {
        return paymentPort.pay(amount);
    }
}
