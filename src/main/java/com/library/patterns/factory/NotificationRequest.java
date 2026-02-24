package com.library.patterns.factory;

/**
 * 실무형 알림 요청 모델.
 */
public record NotificationRequest(
        String recipient,
        String title,
        String message,
        NotificationPriority priority,
        String tenantId
) {
}
