package com.library.patterns.decorator;

/**
 * 슬랙 알림 기능을 추가하는 데코레이터입니다.
 */
public class SlackDecorator extends NotifierDecorator {

    public SlackDecorator(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public String send(String message) {
        return wrapped.send(message) + " | 슬랙 알림 전송";
    }
}
