/**
 * Template Method 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 주문 처리처럼 단계는 고정인데 일부 구현만 채널별로 달라질 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code OrderTemplateDemo}가 {@code OrderContext}를 준비합니다.
 * 2) {@code OrderProcessTemplate#process}가 전체 알고리즘 뼈대를 실행합니다.
 * 3) validate/pay/prepareDelivery 단계를 순차 실행하고 latency를 누적합니다.
 * 4) 성공/실패를 {@code OrderProcessResult}로 표준화합니다.
 *
 * <h2>핵심 포인트</h2>
 * - 절차 통제(공통 품질) + 단계 확장(유연성) 동시 확보
 * - before/after hook으로 추가 정책 주입
 * - 실패 분류를 표준화해 운영 대응 단순화
 */
package com.library.patterns.template;
