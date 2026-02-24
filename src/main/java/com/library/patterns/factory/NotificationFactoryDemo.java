package com.library.patterns.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Factory Method 패턴 데모입니다.
 */
@Component
public class NotificationFactoryDemo {

    private final NotificationCreator emailCreator;
    private final NotificationCreator smsCreator;

    public NotificationFactoryDemo(
            @Qualifier("emailNotificationCreator") NotificationCreator emailCreator,
            @Qualifier("smsNotificationCreator") NotificationCreator smsCreator
    ) {
        this.emailCreator = emailCreator;
        this.smsCreator = smsCreator;
    }

    public void run() {
        NotificationRequest orderPaid = new NotificationRequest(
                "member@company.com",
                "주문 결제 완료",
                "ORD-2026-01 결제가 완료되었습니다.",
                NotificationPriority.NORMAL,
                "tenant-a"
        );

        NotificationRequest incident = new NotificationRequest(
                "010-1234-5678",
                "장애 알림",
                "결제 승인 지연률 급증",
                NotificationPriority.CRITICAL,
                "tenant-a"
        );

        System.out.println(emailCreator.notifyUser(orderPaid));
        System.out.println(smsCreator.notifyUser(orderPaid));
        System.out.println(smsCreator.notifyUser(incident));
    }
}
