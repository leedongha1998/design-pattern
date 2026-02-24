/**
 * Proxy 패키지 학습 가이드.
 *
 * <h2>언제 보는가?</h2>
 * 원본 서비스 호출이 비싸거나, 캐시/폴백/권한 같은 횡단 관심사가 필요할 때 학습합니다.
 *
 * <h2>진행 흐름</h2>
 * 1) {@code CachedProductServiceProxy}가 먼저 캐시를 조회합니다.
 * 2) TTL 내 캐시는 즉시 반환하고, 만료 시 원본 서비스 호출을 시도합니다.
 * 3) 원본 호출 실패 시 stale 캐시 fallback을 적용합니다.
 * 4) 조회 결과를 {@code ProductSnapshot}으로 통일합니다.
 *
 * <h2>핵심 포인트</h2>
 * - 성능 최적화와 장애 완화 전략을 호출부 밖으로 분리
 * - 원본 서비스는 순수 도메인 조회 책임만 유지
 */
package com.library.patterns.proxy;
