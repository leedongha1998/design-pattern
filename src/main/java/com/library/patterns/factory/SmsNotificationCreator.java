package com.library.patterns.factory;

import org.springframework.stereotype.Component;

/**
 * SMS 전송 객체를 생성하는 Creator입니다.
 */
@Component("smsNotificationCreator")
public class SmsNotificationCreator extends NotificationCreator {

    @Override
    protected NotificationSender createSender() {
        return new SmsNotificationSender();
    }
}
