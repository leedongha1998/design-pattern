package com.library.patterns.factory;

/**
 * Factory Method 패턴의 Creator 추상 클래스입니다.
 *
 * <p>생성(createSender)과 공통 처리(요청 검증/테넌트 정책)는 분리합니다.
 */
public abstract class NotificationCreator {

    protected abstract NotificationSender createSender();

    public NotificationResult notifyUser(NotificationRequest request) {
        if (request.recipient() == null || request.recipient().isBlank()) {
            return new NotificationResult(channelName(), false, "", "수신자가 비어 있습니다");
        }
        if (request.tenantId() == null || request.tenantId().isBlank()) {
            return new NotificationResult(channelName(), false, "", "tenantId가 없습니다");
        }

        NotificationSender sender = createSender();
        return sender.send(request);
    }

    protected String channelName() {
        return getClass().getSimpleName().replace("NotificationCreator", "").toUpperCase();
    }
}
