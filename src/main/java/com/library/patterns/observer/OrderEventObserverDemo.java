package com.library.patterns.observer;

import jakarta.annotation.PostConstruct;
import java.time.Instant;
import org.springframework.stereotype.Component;

/**
 * Observer 패턴 데모입니다.
 */
@Component
public class OrderEventObserverDemo {

    private final OrderEventPublisher publisher;

    public OrderEventObserverDemo(OrderEventPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * 데모 리스너를 초기 등록합니다.
     */
    @PostConstruct
    void initListeners() {
        publisher.register(new SlackOrderListener());
        publisher.register(new AuditOrderListener());
    }

    public void run() {
        publisher.notifyChanged(new OrderEvent("ORD-2026-001", "PAID", "SYSTEM", Instant.now()));
        publisher.notifyChanged(new OrderEvent("ORD-2026-001", "PACKING", "WMS", Instant.now()));
        publisher.notifyChanged(new OrderEvent("ORD-2026-001", "SHIPPED", "WMS", Instant.now()));
    }
}
