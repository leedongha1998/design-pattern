package com.library.patterns.template;

/**
 * Template Method 패턴의 추상 클래스입니다.
 *
 * <p>process()는 전체 알고리즘의 뼈대이며,
 * 일부 단계만 하위 클래스에서 구체화합니다.
 */
public abstract class OrderProcessTemplate {

    public final String process(String orderNo) {
        validate(orderNo);
        String paymentResult = pay(orderNo);
        String deliveryResult = prepareDelivery(orderNo);
        return paymentResult + " / " + deliveryResult;
    }

    protected void validate(String orderNo) {
        if (orderNo == null || orderNo.isBlank()) {
            throw new IllegalArgumentException("주문번호가 비어 있습니다.");
        }
    }

    protected abstract String pay(String orderNo);

    protected abstract String prepareDelivery(String orderNo);
}
