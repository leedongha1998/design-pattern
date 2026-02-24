package com.library.patterns.decorator;

/**
 * 알림 전송 기능의 공통 인터페이스입니다.
 */
public interface Notifier {

    /**
     * 전달받은 메시지를 전송합니다.
     */
    String send(String message);
}
