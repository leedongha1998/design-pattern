package com.library.patterns.factory;

/**
 * 알림 전송 결과 모델.
 */
public record NotificationResult(
        String channel,
        boolean success,
        String providerMessageId,
        String detail
) {
}
