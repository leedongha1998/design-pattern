package com.library.patterns.factory;

import org.springframework.stereotype.Component;

/**
 * 이메일 전송 객체를 생성하는 Creator입니다.
 */
@Component("emailNotificationCreator")
public class EmailNotificationCreator extends NotificationCreator {

    @Override
    protected NotificationSender createSender() {
        return new EmailNotificationSender();
    }
}
