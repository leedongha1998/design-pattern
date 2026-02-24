package com.library.patterns.adapter;

/**
 * 레거시 결제 모듈(기존 시스템) 예시입니다.
 *
 * <p>신규 서비스가 기대하는 인터페이스와 메서드 시그니처가 다르다고 가정합니다.
 */
public class LegacyPaymentClient {

    public String execute(int price) {
        return "레거시 결제 성공: " + price + "원";
    }
}
