package com.library.patterns.factory;

/**
 * SMS 알림 전송 구현체입니다.
 */
public class SmsNotificationSender implements NotificationSender {

    @Override
    public String send(String message) {
        return "[SMS] " + message;
    }
}
