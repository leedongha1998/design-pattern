package com.library.patterns.facade;

/**
 * 퍼사드 하위 단계 처리 결과.
 */
public record FacadeStepResult(
        String step,
        boolean success,
        String detail,
        long latencyMs
) {
}
