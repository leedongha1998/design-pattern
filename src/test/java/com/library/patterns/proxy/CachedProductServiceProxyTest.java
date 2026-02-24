package com.library.patterns.proxy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

class CachedProductServiceProxyTest {

    @Test
    void should_hitCache_when_secondCallWithinTtl() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        ProductService service = new CachedProductServiceProxy(new RealProductService(), Duration.ofMinutes(1), fixedClock);

        ProductSnapshot first = service.findProduct(1L);
        ProductSnapshot second = service.findProduct(1L);

        assertFalse(first.fromCache());
        assertTrue(second.fromCache());
    }
}
