package com.library.patterns.observer;

/**
 * 감사 로그를 남기는 옵저버 구현체입니다.
 */
public class AuditOrderListener implements OrderEventListener {

    @Override
    public void onChanged(String orderNo, String status) {
        System.out.println("[AUDIT] " + orderNo + " -> " + status + " 기록 완료");
    }
}
