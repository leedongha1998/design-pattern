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

    public void notifyChanged(String orderNo, String status) {
        listeners.forEach(listener -> listener.onChanged(orderNo, status));
    }
}
