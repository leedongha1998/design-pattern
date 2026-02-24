package com.library.patterns.strategy;

/**
 * 결제 전략(Strategy) 인터페이스입니다.
 *
 * <p>결제 방식(카드, 계좌이체, 간편결제 등)을 구현체로 분리해
 * 런타임에 자유롭게 교체할 수 있게 해줍니다.
 */
public interface PaymentStrategy {

    /**
     * 금액을 결제합니다.
     *
     * @param amount 결제 금액
     * @return 결제 결과 메시지
     */
    String pay(int amount);
}
