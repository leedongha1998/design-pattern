package com.library.patterns.decorator;

/**
 * SMS 알림 기능을 추가하는 데코레이터입니다.
 */
public class SmsDecorator extends NotifierDecorator {

    public SmsDecorator(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public String send(String message) {
        return wrapped.send(message) + " | SMS 알림 전송";
    }
}
