package com.library.patterns.factory;

/**
 * 이메일 알림 전송 구현체입니다.
 */
public class EmailNotificationSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "[EMAIL] " + message;
    }
}
