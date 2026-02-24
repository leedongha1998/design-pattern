package com.library.patterns.factory;

import java.util.UUID;

/**
 * SMS 알림 전송 구현체입니다.
 */
public class SmsNotificationSender implements NotificationSender {

    @Override
    public NotificationResult send(NotificationRequest request) {
        boolean allowed = request.priority() == NotificationPriority.HIGH
                || request.priority() == NotificationPriority.CRITICAL;

        if (!allowed) {
            return new NotificationResult("SMS", false, "", "SMS는 HIGH 이상 우선순위에서만 허용됩니다");
        }

        return new NotificationResult(
                "SMS",
                true,
                "sms-" + UUID.randomUUID(),
                "to=" + request.recipient() + ", len=" + request.message().length()
        );
    }
}
