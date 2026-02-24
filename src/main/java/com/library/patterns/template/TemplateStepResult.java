package com.library.patterns.template;

/**
 * 단계별 처리 결과.
 */
public record TemplateStepResult(
        String step,
        boolean success,
        String detail,
        long latencyMs
) {
}
