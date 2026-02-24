/**
 * Factory Method 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 생성 규칙이 채널/우선순위/테넌트별로 달라질 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code NotificationFactoryDemo}가 알림 요청을 생성합니다.
 * 2) {@code NotificationCreator}가 공통 검증(수신자/tenant)을 수행합니다.
 * 3) 하위 Creator가 {@code NotificationSender} 구현체를 생성합니다.
 * 4) Sender가 채널별 정책으로 전송하고 {@code NotificationResult}를 반환합니다.
 *
 * <h2>핵심 포인트</h2>
 * - 생성 책임과 사용 책임 분리
 * - 공통 전처리는 상위 Creator에서 강제
 * - 채널별 확장 시 기존 호출부 변경 최소화
 */
package com.library.patterns.factory;
