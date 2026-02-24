package com.library.patterns.template;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class OrderProcessTemplateTest {

    private final RegularOrderProcess process = new RegularOrderProcess();

    @Test
    void should_succeedProcess_when_contextIsValid() {
        OrderContext context = new OrderContext("ORD-1", "CUS-1", new BigDecimal("10000"), "B2C", "trace-1");

        OrderProcessResult result = process.process(context);

        assertTrue(result.success());
        assertTrue(result.steps().size() >= 3);
    }

    @Test
    void should_failValidation_when_amountIsZero() {
        OrderContext context = new OrderContext("ORD-2", "CUS-1", BigDecimal.ZERO, "B2C", "trace-2");

        OrderProcessResult result = process.process(context);

        assertFalse(result.success());
        assertTrue("VALIDATION_ERROR".equals(result.errorCode()));
    }
}
