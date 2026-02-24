package com.library.patterns.observer;

/**
 * 주문 이벤트를 받는 옵저버(리스너) 인터페이스입니다.
 */
public interface OrderEventListener {

    /**
     * 이 리스너가 해당 이벤트를 처리할지 여부.
     */
    default boolean supports(OrderEvent event) {
        return true;
    }

    /**
     * 주문 상태 변경 이벤트를 처리합니다.
     */
    void onChanged(OrderEvent event);

    /**
     * 리스너 이름.
     */
    default String name() {
        return getClass().getSimpleName();
    }
}
