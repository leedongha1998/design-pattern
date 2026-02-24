package com.library.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 옵저버들을 관리하고 이벤트를 발행하는 Subject(발행자)입니다.
 */
@Component
public class OrderEventPublisher {

    private final List<OrderEventListener> listeners = new ArrayList<>();

    public void register(OrderEventListener listener) {
        listeners.add(listener);
    }

    public void notifyChanged(OrderEvent event) {
        for (OrderEventListener listener : listeners) {
            if (!listener.supports(event)) {
                continue;
            }
            try {
                listener.onChanged(event);
            } catch (RuntimeException e) {
                System.out.println("[WARN] listener 실패: " + listener.name() + " - " + e.getMessage());
            }
        }
    }
}
