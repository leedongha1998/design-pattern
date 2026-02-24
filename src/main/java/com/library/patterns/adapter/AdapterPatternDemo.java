package com.library.patterns.adapter;

import org.springframework.stereotype.Component;

/**
 * Adapter 패턴 데모입니다.
 */
@Component
public class AdapterPatternDemo {

    private final PaymentService paymentService;

    public AdapterPatternDemo(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void run() {
        PaymentPort adapter = new LegacyPaymentAdapter(new LegacyPaymentClient());
        System.out.println(paymentService.pay(15000, adapter));
    }
}
