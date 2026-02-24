package com.library.patterns.facade;

import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Facade 패턴 데모입니다.
 */
@Component
public class FacadePatternDemo {

    public void run() {
        OrderFacade orderFacade = new OrderFacade();
        System.out.println(orderFacade.placeOrder(new PlaceOrderCommand(
                "ORD-2026-101", "P-1", 22000, "CUS-31", UUID.randomUUID().toString())));
        System.out.println(orderFacade.placeOrder(new PlaceOrderCommand(
                "ORD-2026-102", "P-0", 22000, "CUS-31", UUID.randomUUID().toString())));
    }
}
