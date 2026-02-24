package com.library.patterns.factory;

import java.util.UUID;

/**
 * 이메일 알림 전송 구현체입니다.
 */
public class EmailNotificationSender implements NotificationSender {

    @Override
    public NotificationResult send(NotificationRequest request) {
        return new NotificationResult(
                "EMAIL",
                true,
                "mail-" + UUID.randomUUID(),
                "subject='" + request.title() + "', to=" + request.recipient()
        );
    }
}
