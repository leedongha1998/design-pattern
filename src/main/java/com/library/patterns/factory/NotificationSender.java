package com.library.patterns.factory;

/**
 * 알림 전송 객체의 공통 인터페이스입니다.
 */
public interface NotificationSender {

    /**
     * 알림을 전송합니다.
     */
    String send(String message);
}
