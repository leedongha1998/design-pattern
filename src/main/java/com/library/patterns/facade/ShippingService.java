package com.library.patterns.facade;

/**
 * 배송 처리 서브 시스템입니다.
 */
public class ShippingService {

    public String requestDelivery(String orderNo) {
        return "배송 요청 완료(" + orderNo + ")";
    }
}
