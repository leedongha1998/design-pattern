package com.library.patterns.decorator;

/**
 * 가장 기본이 되는 알림 전송 구현체입니다.
 */
public class BasicNotifier implements Notifier {

    @Override
    public String send(String message) {
        return "기본 알림 전송: " + message;
    }
}
