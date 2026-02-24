package com.library.patterns.template;

import org.springframework.stereotype.Component;

/**
 * 일반 주문 처리 흐름 구현체입니다.
 */
@Component
public class RegularOrderProcess extends OrderProcessTemplate {

    @Override
    protected void beforeProcess(OrderContext context) {
        if ("B2B".equals(context.channel()) && context.amount().intValue() < 5000) {
            throw new IllegalArgumentException("B2B 최소 주문 금액 미달");
        }
    }

    @Override
    protected String pay(OrderContext context) {
        return "결제 게이트웨이 승인(" + context.orderNo() + ")";
    }

    @Override
    protected String prepareDelivery(OrderContext context) {
        return "물류센터 피킹 생성(" + context.orderNo() + ")";
    }
}
