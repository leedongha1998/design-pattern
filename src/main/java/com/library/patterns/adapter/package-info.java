/**
 * Adapter 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 레거시 API 시그니처와 신규 포트 인터페이스가 다를 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code PaymentService}는 신규 포트({@code PaymentPort})만 의존합니다.
 * 2) {@code LegacyPaymentAdapter}가 레거시 호출을 포트 규격으로 변환합니다.
 * 3) 호출부는 레거시 세부사항을 몰라도 결제 흐름을 유지합니다.
 *
 * <h2>핵심 포인트</h2>
 * - 점진적 마이그레이션
 * - 도메인 코드의 외부 의존 오염 방지
 */
package com.library.patterns.adapter;
