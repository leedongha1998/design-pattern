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
        System.out.println(emailCreator.notifyUser("주문이 완료되었습니다."));
        System.out.println(smsCreator.notifyUser("배송이 시작되었습니다."));
    }
}
