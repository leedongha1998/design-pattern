package com.library.patterns.facade;

/**
 * 재고 확인 서브 시스템입니다.
 */
public class InventoryService {

    public String reserve(String productId) {
        return "재고 예약 완료(" + productId + ")";
    }
}
