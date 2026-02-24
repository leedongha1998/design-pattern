package com.library.patterns.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CheckoutServiceTest {

    private final CheckoutService checkoutService = new CheckoutService();

    @Test
    void shouldReturnSameResultForSameIdempotencyKey() {
        PaymentRequest request = new PaymentRequest(
                "ORD-1",
                "CUS-1",
                new BigDecimal("50000"),
                "KRW",
                false,
                3,
                "idem-1"
        );

        PaymentResult first = checkoutService.checkout(request, new CardPaymentStrategy());
        PaymentResult second = checkoutService.checkout(request, new KakaoPayStrategy());

        assertEquals(first.traceId(), second.traceId());
        assertEquals(first.provider(), second.provider());
    }

    @Test
    void shouldRejectInvalidAmount() {
        PaymentRequest request = new PaymentRequest(
                "ORD-2",
                "CUS-2",
                BigDecimal.ZERO,
                "KRW",
                false,
                1,
                "idem-2"
        );

        PaymentResult result = checkoutService.checkout(request, new CardPaymentStrategy());

        assertFalse(result.approved());
        assertEquals("VALIDATION-ERROR", result.traceId());
    }

    @Test
    void shouldRejectHighRiskKakaoPayment() {
        PaymentRequest request = new PaymentRequest(
                "ORD-3",
                "CUS-3",
                new BigDecimal("200000"),
                "KRW",
                true,
                1,
                "idem-3"
        );

        PaymentResult result = checkoutService.checkout(request, new KakaoPayStrategy());

        assertFalse(result.approved());
        assertTrue(result.message().contains("고위험"));
    }
}
