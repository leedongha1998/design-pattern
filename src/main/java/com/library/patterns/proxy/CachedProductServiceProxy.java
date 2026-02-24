package com.library.patterns.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * 캐시 기능을 추가한 Proxy 클래스입니다.
 *
 * <p>원본 서비스 호출 전 캐시를 먼저 확인해서,
 * 반복 요청 시 성능을 개선하는 예시를 보여줍니다.
 */
public class CachedProductServiceProxy implements ProductService {

    private final ProductService target;
    private final Map<Long, String> cache = new HashMap<>();

    public CachedProductServiceProxy(ProductService target) {
        this.target = target;
    }

    @Override
    public String findProductName(long productId) {
        if (cache.containsKey(productId)) {
            return "[CACHE HIT] " + cache.get(productId);
        }

        String value = target.findProductName(productId);
        cache.put(productId, value);
        return "[CACHE MISS] " + value;
    }
}
