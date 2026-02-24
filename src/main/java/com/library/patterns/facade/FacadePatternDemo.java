package com.library.patterns.facade;

import org.springframework.stereotype.Component;

/**
 * Facade 패턴 데모입니다.
 */
@Component
public class FacadePatternDemo {

    public void run() {
        OrderFacade orderFacade = new OrderFacade();
        System.out.println(orderFacade.placeOrder("ORD-2026-101", "P-1", 22000));
    }
}
