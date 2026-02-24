package com.library.patterns.template;

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
        System.out.println(regularOrderProcess.process("ORD-2026-001"));
    }
}
