package com.library.patterns.proxy;

import java.time.Instant;

/**
 * 실제 데이터 조회를 담당하는 원본 서비스입니다.
 */
public class RealProductService implements ProductService {

    @Override
    public ProductSnapshot findProduct(long productId) {
        // 실제 현업에서는 DB/API 호출이 여기에 들어갑니다.
        if (productId == 999L) {
            throw new IllegalStateException("원격 상품 조회 실패");
        }
        return new ProductSnapshot(productId, "상품-" + productId, (int) (productId * 10), Instant.now(), false);
    }
}
