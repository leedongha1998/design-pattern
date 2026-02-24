package com.library.patterns.proxy;

import java.time.Instant;

/**
 * 상품 조회 스냅샷.
 */
public record ProductSnapshot(
        long productId,
        String name,
        int price,
        Instant loadedAt,
        boolean fromCache
) {
}
