package com.library.patterns.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OrderFacadeTest {

    private final OrderFacade facade = new OrderFacade();

    @Test
    void should_succeedPlaceOrder_when_inputIsValid() {
        PlaceOrderResult result = facade.placeOrder(new PlaceOrderCommand(
                "ORD-1", "P-1", 10000, "CUS-1", "trace-1"));

        assertTrue(result.success());
        assertEquals(3, result.steps().size());
    }

    @Test
    void should_failAtInventory_when_productIsOutOfStock() {
        PlaceOrderResult result = facade.placeOrder(new PlaceOrderCommand(
                "ORD-2", "P-0", 10000, "CUS-1", "trace-2"));

        assertFalse(result.success());
        assertEquals("inventory", result.failedAt());
    }
}
