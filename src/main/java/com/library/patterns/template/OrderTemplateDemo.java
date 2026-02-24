package com.library.patterns.template;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Template Method 패턴 데모입니다.
 */
@Component
public class OrderTemplateDemo {

    private final RegularOrderProcess regularOrderProcess;

    public OrderTemplateDemo(RegularOrderProcess regularOrderProcess) {
        this.regularOrderProcess = regularOrderProcess;
    }

    public void run() {
        OrderContext context = new OrderContext(
                "ORD-2026-001",
                "CUS-101",
                new BigDecimal("38000"),
                "B2C",
                UUID.randomUUID().toString()
        );
        System.out.println(regularOrderProcess.process(context));
    }
}
