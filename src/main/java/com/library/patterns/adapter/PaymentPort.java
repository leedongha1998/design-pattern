package com.library.patterns.adapter;

/**
 * 신규 서비스가 기대하는 결제 포트(목표 인터페이스)입니다.
 */
public interface PaymentPort {

    String pay(int amount);
}
