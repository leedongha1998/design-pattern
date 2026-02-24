/**
 * Observer 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 주문 상태 변경 후 알림/감사로그/후처리가 다수로 갈라질 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code OrderEventObserverDemo}가 도메인 이벤트를 발행합니다.
 * 2) {@code OrderEventPublisher}가 등록된 리스너를 순회합니다.
 * 3) 리스너별 {@code supports} 필터를 통과한 경우에만 처리합니다.
 * 4) 특정 리스너 실패는 격리하여 전체 흐름을 보호합니다.
 *
 * <h2>핵심 포인트</h2>
 * - 핵심 트랜잭션과 부가 기능의 결합도 축소
 * - 리스너 확장 비용 감소
 * - 이벤트 기반 후처리 품질 확보
 */
package com.library.patterns.observer;
