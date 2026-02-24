/**
 * Strategy 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 결제/할인/정렬처럼 "정책"만 자주 바뀌고 호출 흐름은 비슷할 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code PaymentStrategyDemo}가 결제 시나리오를 준비합니다.
 * 2) {@code CheckoutService}가 공통 로직(검증/멱등성/리스크)을 처리합니다.
 * 3) {@code PaymentStrategy} 구현체(카드/카카오페이)가 실제 정책을 수행합니다.
 * 4) 결과는 {@code PaymentResult}로 통일되어 상위 계층이 해석합니다.
 *
 * <h2>핵심 포인트</h2>
 * - if/else 폭증을 구현체 분리로 제어
 * - 전략 교체는 런타임 선택으로 처리
 * - 공통 처리와 정책 처리를 분리해서 테스트 용이성 확보
 */
package com.library.patterns.strategy;
