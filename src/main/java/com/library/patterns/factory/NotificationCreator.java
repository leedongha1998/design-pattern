package com.library.patterns.factory;

/**
 * Factory Method 패턴의 Creator 추상 클래스입니다.
 *
 * <p>실제 생성 로직(createSender)은 하위 클래스가 결정하고,
 * 공통 비즈니스 흐름(notifyUser)은 상위에서 재사용합니다.
 */
public abstract class NotificationCreator {

    protected abstract NotificationSender createSender();

    public String notifyUser(String message) {
        NotificationSender sender = createSender();
        return sender.send(message);
    }
}
