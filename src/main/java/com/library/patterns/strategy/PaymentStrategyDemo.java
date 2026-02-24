package com.library.patterns.strategy;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Strategy 패턴 동작을 실무형 시나리오로 보여주는 데모 클래스입니다.
 */
@Component
public class PaymentStrategyDemo {

    private final CheckoutService checkoutService;

    public PaymentStrategyDemo(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    public void run() {
        PaymentRequest regularCardOrder = new PaymentRequest(
                "ORD-1001",
                "CUS-10",
                new BigDecimal("12000"),
                "KRW",
                false,
                2,
                "idem-card-1001"
        );

        PaymentRequest highRiskKakaoOrder = new PaymentRequest(
                "ORD-1002",
                "CUS-77",
                new BigDecimal("180000"),
                "KRW",
                true,
                1,
                "idem-kakao-1002"
        );

        PaymentResult cardResult = checkoutService.checkout(regularCardOrder, new CardPaymentStrategy());
        PaymentResult kakaoResult = checkoutService.checkout(highRiskKakaoOrder, new KakaoPayStrategy());
        PaymentResult duplicatedRetry = checkoutService.checkout(highRiskKakaoOrder, new KakaoPayStrategy());

        System.out.println(format(cardResult));
        System.out.println(format(kakaoResult));
        System.out.println("멱등성 재요청 결과 동일 traceId: " + duplicatedRetry.traceId().equals(kakaoResult.traceId()));
    }

    private String format(PaymentResult result) {
        return String.format("[%s] approved=%s, charged=%s, fee=%s, message=%s, traceId=%s",
                result.provider(),
                result.approved(),
                result.chargedAmount(),
                result.fee(),
                result.message(),
                result.traceId());
    }
}
