package com.library.patterns.strategy;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

/**
 * 결제 전략을 사용하는 컨텍스트(Context) 클래스입니다.
 *
 * <p>단순 전략 호출을 넘어, 실무에서 자주 필요한 공통 흐름(리스크 판단, 멱등성, 재시도 판별)을
 * 컨텍스트에서 통합 처리합니다.
 */
@Component
public class CheckoutService {

    private final Map<String, PaymentResult> idempotencyStore = new ConcurrentHashMap<>();
    private final Map<String, Integer> customerAttemptCounter = new ConcurrentHashMap<>();

    /**
     * 전달받은 전략으로 결제를 수행합니다.
     */
    public PaymentResult checkout(PaymentRequest request, PaymentStrategy strategy) {
        if (request.amount().compareTo(BigDecimal.ZERO) <= 0) {
            return new PaymentResult("SYSTEM", false, request.amount(), BigDecimal.ZERO,
                    "결제 금액은 0보다 커야 합니다", "VALIDATION-ERROR");
        }

        PaymentResult duplicated = idempotencyStore.get(request.idempotencyKey());
        if (duplicated != null) {
            return duplicated;
        }

        int attempts = customerAttemptCounter.merge(request.customerId(), 1, Integer::sum);
        boolean sameDayRetry = attempts > 1;
        RiskLevel riskLevel = evaluateRisk(request, attempts);

        PaymentResult result = strategy.pay(request, riskLevel, sameDayRetry);
        idempotencyStore.put(request.idempotencyKey(), result);
        return result;
    }

    private RiskLevel evaluateRisk(PaymentRequest request, int attempts) {
        boolean highAmount = request.amount().compareTo(new BigDecimal("100000")) >= 0;
        boolean lowLoyalty = request.loyaltyTier() <= 1;

        if (highAmount && (attempts >= 2 || lowLoyalty)) {
            return RiskLevel.HIGH;
        }
        if (highAmount || attempts >= 2 || lowLoyalty) {
            return RiskLevel.MEDIUM;
        }
        return RiskLevel.LOW;
    }
}
