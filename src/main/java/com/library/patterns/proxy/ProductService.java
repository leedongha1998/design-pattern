package com.library.patterns.proxy;

/**
 * 상품 정보를 조회하는 서비스 인터페이스입니다.
 */
public interface ProductService {

    /**
     * 상품 정보를 조회합니다.
     */
    ProductSnapshot findProduct(long productId);
}
