package com.library.patterns.common;

import org.springframework.stereotype.Component;

/**
 * 패턴 데모 실행 러너.
 */
@Component
public class DemoScenarioRunner {

    public ScenarioResult runScenario(String scenarioName, Runnable runnable) {
        long startedAt = System.currentTimeMillis();
        try {
            runnable.run();
            return new ScenarioResult(scenarioName, true, System.currentTimeMillis() - startedAt, "");
        } catch (RuntimeException e) {
            return new ScenarioResult(scenarioName, false, System.currentTimeMillis() - startedAt, "SCENARIO_FAILED");
        }
    }
}
