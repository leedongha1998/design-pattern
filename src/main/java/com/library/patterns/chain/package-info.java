/**
 * Chain of Responsibility 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 승인/검증 규칙이 단계적으로 누적되고 조직/한도 정책이 자주 바뀔 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code ChainOfResponsibilityDemo}가 팀장->부서장->임원 체인을 구성합니다.
 * 2) {@code ApprovalRequest}가 첫 핸들러로 들어갑니다.
 * 3) 현재 핸들러가 처리 불가하면 다음 핸들러로 위임합니다.
 * 4) 최종 결과는 {@code ApprovalDecision}으로 통일합니다.
 *
 * <h2>핵심 포인트</h2>
 * - 단계별 책임 분리
 * - 규칙 추가를 핸들러 추가로 처리
 */
package com.library.patterns.chain;
