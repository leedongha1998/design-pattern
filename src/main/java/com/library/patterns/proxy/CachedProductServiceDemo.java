package com.library.patterns.proxy;

import org.springframework.stereotype.Component;

/**
 * Proxy 패턴 데모입니다.
 */
@Component
public class CachedProductServiceDemo {

    public void run() {
        ProductService service = new CachedProductServiceProxy(new RealProductService());

        System.out.println(service.findProduct(100L));
        System.out.println(service.findProduct(100L));

        try {
            System.out.println(service.findProduct(999L));
        } catch (RuntimeException e) {
            System.out.println("[FALLBACK MISS] " + e.getMessage());
        }
    }
}
