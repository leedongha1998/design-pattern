package com.library.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

/**
 * 간편결제(카카오페이) 전략입니다.
 */
public class KakaoPayStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay(PaymentRequest request, RiskLevel riskLevel, boolean sameDayRetry) {
        BigDecimal feeRate = request.firstOrder()
                ? new BigDecimal("0.008")
                : new BigDecimal("0.012");

        if (riskLevel == RiskLevel.HIGH) {
            // 고위험 거래는 간편결제 승인 실패 확률이 높다고 가정해 보수적으로 거절.
            return new PaymentResult(
                    "KAKAOPAY",
                    false,
                    request.amount(),
                    BigDecimal.ZERO,
                    "고위험 거래로 간편결제 승인이 불가합니다",
                    UUID.randomUUID().toString()
            );
        }

        if (sameDayRetry) {
            // 재시도 요청은 재처리 비용이 추가.
            feeRate = feeRate.add(new BigDecimal("0.002"));
        }

        BigDecimal fee = request.amount().multiply(feeRate).setScale(0, RoundingMode.UP);
        BigDecimal charged = request.amount().add(fee);

        return new PaymentResult(
                "KAKAOPAY",
                true,
                charged,
                fee,
                "카카오페이 결제 승인",
                UUID.randomUUID().toString()
        );
    }
}
