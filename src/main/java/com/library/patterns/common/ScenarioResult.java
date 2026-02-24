package com.library.patterns.common;

/**
 * 공통 데모 실행 결과.
 */
public record ScenarioResult(
        String scenario,
        boolean success,
        long latencyMs,
        String errorCode
) {
}
