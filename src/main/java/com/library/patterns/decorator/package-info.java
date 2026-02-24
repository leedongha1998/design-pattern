/**
 * Decorator 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 같은 기능에 옵션 조합(예: SMS + Slack + 감사로그)이 늘어날 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) 기본 구현체({@code BasicNotifier})를 준비합니다.
 * 2) 데코레이터({@code SmsDecorator}, {@code SlackDecorator})를 감쌉니다.
 * 3) 최종 {@code send} 호출 시 바깥 데코레이터부터 순차 실행됩니다.
 *
 * <h2>핵심 포인트</h2>
 * - 상속 없이 기능 조합
 * - 기능 추가 시 기존 코드 수정 최소화
 */
package com.library.patterns.decorator;
