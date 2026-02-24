package com.library.patterns.observer;

import java.util.Set;

/**
 * 슬랙 알림을 보내는 옵저버 구현체입니다.
 */
public class SlackOrderListener implements OrderEventListener {

    private static final Set<String> IMPORTANT = Set.of("PAID", "SHIPPED", "CANCELLED");

    @Override
    public boolean supports(OrderEvent event) {
        return IMPORTANT.contains(event.status());
    }

    @Override
    public void onChanged(OrderEvent event) {
        System.out.println("[SLACK] " + event.orderNo() + " 상태 변경: " + event.status());
    }
}
