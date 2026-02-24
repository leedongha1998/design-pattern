package com.library.patterns.strategy;

/**
 * 결제 전략(Strategy) 인터페이스입니다.
 *
 * <p>실제 결제 시스템에서는 전략마다 수수료, 승인 조건, 리스크 정책이 다를 수 있습니다.
 */
public interface PaymentStrategy {

    /**
     * 결제를 수행합니다.
     */
    PaymentResult pay(PaymentRequest request, RiskLevel riskLevel, boolean sameDayRetry);
}
