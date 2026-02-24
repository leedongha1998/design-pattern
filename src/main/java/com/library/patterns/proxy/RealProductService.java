package com.library.patterns.proxy;

/**
 * 실제 데이터 조회를 담당하는 원본 서비스입니다.
 */
public class RealProductService implements ProductService {

    @Override
    public String findProductName(long productId) {
        // 실제 현업에서는 DB/API 호출이 여기에 들어갑니다.
        return "상품-" + productId;
    }
}
