package com.library.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

/**
 * 신용카드 결제 전략입니다.
 */
public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay(PaymentRequest request, RiskLevel riskLevel, boolean sameDayRetry) {
        BigDecimal feeRate = riskLevel == RiskLevel.HIGH
                ? new BigDecimal("0.032")
                : new BigDecimal("0.025");

        // 당일 재시도 고객은 카드사 리스크 정책으로 추가 인증 수수료를 가정.
        if (sameDayRetry) {
            feeRate = feeRate.add(new BigDecimal("0.003"));
        }

        BigDecimal fee = request.amount().multiply(feeRate).setScale(0, RoundingMode.UP);
        BigDecimal charged = request.amount().add(fee);

        boolean approved = riskLevel != RiskLevel.HIGH || request.loyaltyTier() >= 3;
        String message = approved
                ? "카드 결제 승인"
                : "고위험 거래로 카드 결제가 거절되었습니다";

        return new PaymentResult(
                "CARD",
                approved,
                charged,
                fee,
                message,
                UUID.randomUUID().toString()
        );
    }
}
