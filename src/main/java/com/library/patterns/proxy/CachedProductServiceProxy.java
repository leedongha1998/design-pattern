package com.library.patterns.proxy;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 캐시 기능을 추가한 Proxy 클래스입니다.
 */
public class CachedProductServiceProxy implements ProductService {

    private final ProductService target;
    private final Map<Long, ProductSnapshot> cache = new HashMap<>();
    private final Duration ttl;
    private final Clock clock;

    public CachedProductServiceProxy(ProductService target) {
        this(target, Duration.ofSeconds(30), Clock.systemUTC());
    }

    public CachedProductServiceProxy(ProductService target, Duration ttl) {
        this(target, ttl, Clock.systemUTC());
    }

    public CachedProductServiceProxy(ProductService target, Duration ttl, Clock clock) {
        this.target = target;
        this.ttl = ttl;
        this.clock = clock;
    }

    @Override
    public ProductSnapshot findProduct(long productId) {
        ProductSnapshot cached = cache.get(productId);
        if (cached != null && !isExpired(cached)) {
            return new ProductSnapshot(cached.productId(), cached.name(), cached.price(), cached.loadedAt(), true);
        }

        try {
            ProductSnapshot latest = target.findProduct(productId);
            cache.put(productId, latest);
            return latest;
        } catch (RuntimeException ex) {
            if (cached != null) {
                return new ProductSnapshot(cached.productId(), cached.name(), cached.price(), cached.loadedAt(), true);
            }
            throw ex;
        }
    }

    private boolean isExpired(ProductSnapshot snapshot) {
        return snapshot.loadedAt().plus(ttl).isBefore(Instant.now(clock));
    }
}
