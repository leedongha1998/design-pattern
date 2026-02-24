package com.library.patterns.factory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NotificationCreatorTest {

    @Test
    void should_failSms_when_priorityIsNormal() {
        NotificationCreator creator = new SmsNotificationCreator();
        NotificationRequest request = new NotificationRequest(
                "010-1111-2222", "notice", "hello", NotificationPriority.NORMAL, "tenant-a");

        NotificationResult result = creator.notifyUser(request);

        assertFalse(result.success());
    }

    @Test
    void should_failValidation_when_tenantIsMissing() {
        NotificationCreator creator = new EmailNotificationCreator();
        NotificationRequest request = new NotificationRequest(
                "a@b.com", "notice", "hello", NotificationPriority.NORMAL, "");

        NotificationResult result = creator.notifyUser(request);

        assertFalse(result.success());
        assertTrue(result.detail().contains("tenantId"));
    }
}
