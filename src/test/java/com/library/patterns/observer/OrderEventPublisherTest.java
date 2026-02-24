package com.library.patterns.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class OrderEventPublisherTest {

    @Test
    void should_dispatchEvent_when_listenerSupportsStatus() {
        OrderEventPublisher publisher = new OrderEventPublisher();
        AtomicInteger called = new AtomicInteger();

        publisher.register(new OrderEventListener() {
            @Override
            public boolean supports(OrderEvent event) {
                return "PAID".equals(event.status());
            }

            @Override
            public void onChanged(OrderEvent event) {
                called.incrementAndGet();
            }
        });

        publisher.notifyChanged(new OrderEvent("O-1", "PACKING", "SYS", Instant.now()));
        publisher.notifyChanged(new OrderEvent("O-1", "PAID", "SYS", Instant.now()));

        assertEquals(1, called.get());
    }
}
