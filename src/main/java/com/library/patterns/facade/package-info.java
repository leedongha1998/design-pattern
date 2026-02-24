/**
 * Facade 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 재고/결제/배송처럼 다중 서브시스템 오케스트레이션이 필요할 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code FacadePatternDemo}가 {@code PlaceOrderCommand}를 전달합니다.
 * 2) {@code OrderFacade}가 inventory -> billing -> shipping 순으로 단계 실행합니다.
 * 3) 각 단계 결과를 {@code FacadeStepResult}로 수집합니다.
 * 4) 전체 결과를 {@code PlaceOrderResult}로 반환해 실패 지점/재시도 가능성을 제공합니다.
 *
 * <h2>핵심 포인트</h2>
 * - 복잡한 호출 시퀀스를 단일 진입점으로 단순화
 * - 단계별 실패 지점 추적 강화
 */
package com.library.patterns.facade;
