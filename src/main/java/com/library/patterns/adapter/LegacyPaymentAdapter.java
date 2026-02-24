package com.library.patterns.adapter;

/**
 * Adapter 패턴 구현체입니다.
 *
 * <p>신규 서비스 인터페이스(PaymentPort)에 맞춰
 * 기존 레거시 클라이언트(LegacyPaymentClient)를 사용할 수 있게 변환합니다.
 */
public class LegacyPaymentAdapter implements PaymentPort {

    private final LegacyPaymentClient legacyClient;

    public LegacyPaymentAdapter(LegacyPaymentClient legacyClient) {
        this.legacyClient = legacyClient;
    }

    @Override
    public String pay(int amount) {
        return legacyClient.execute(amount);
    }
}
