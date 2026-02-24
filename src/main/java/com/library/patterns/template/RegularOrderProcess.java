package com.library.patterns.template;

import org.springframework.stereotype.Component;

/**
 * 일반 주문 처리 흐름 구현체입니다.
 */
@Component
public class RegularOrderProcess extends OrderProcessTemplate {

    @Override
    protected String pay(String orderNo) {
        return "일반 결제 처리 완료(" + orderNo + ")";
    }

    @Override
    protected String prepareDelivery(String orderNo) {
        return "일반 배송 준비 완료(" + orderNo + ")";
    }
}
