package com.library.patterns.observer;

/**
 * 주문 이벤트를 받는 옵저버(리스너) 인터페이스입니다.
 */
public interface OrderEventListener {

    /**
     * 주문 상태 변경 이벤트를 처리합니다.
     */
    void onChanged(String orderNo, String status);
}
