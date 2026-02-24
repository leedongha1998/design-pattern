package com.library.patterns.decorator;

import org.springframework.stereotype.Component;

/**
 * Decorator 패턴 데모입니다.
 */
@Component
public class DecoratorPatternDemo {

    public void run() {
        Notifier notifier = new SmsDecorator(new SlackDecorator(new BasicNotifier()));
        System.out.println(notifier.send("주문 상태가 변경되었습니다."));
    }
}
