package com.library.patterns.observer;

/**
 * 슬랙 알림을 보내는 옵저버 구현체입니다.
 */
public class SlackOrderListener implements OrderEventListener {

    @Override
    public void onChanged(String orderNo, String status) {
        System.out.println("[SLACK] " + orderNo + " 상태 변경: " + status);
    }
}
