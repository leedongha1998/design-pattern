package com.library.patterns.facade;

/**
 * 재고 확인 서브 시스템입니다.
 */
public class InventoryService {

    public String reserve(String productId) {
        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("상품 ID가 비어 있습니다");
        }
        if ("P-0".equals(productId)) {
            throw new IllegalStateException("재고 부족");
        }
        return "재고 예약 완료(" + productId + ")";
    }
}
