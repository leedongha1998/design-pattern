package com.library.patterns.facade;

/**
 * 배송 처리 서브 시스템입니다.
 */
public class ShippingService {

    public String requestDelivery(String orderNo) {
        if (orderNo.startsWith("ORD-BLOCK")) {
            throw new IllegalStateException("배송 금지 주문");
        }
        return "배송 요청 완료(" + orderNo + ")";
    }
}
