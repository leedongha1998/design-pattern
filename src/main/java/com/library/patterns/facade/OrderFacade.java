package com.library.patterns.facade;

/**
 * Facade 패턴의 핵심 클래스입니다.
 *
 * <p>재고/결제/배송처럼 여러 하위 시스템 호출을
 * 하나의 단순한 메서드로 숨겨서 클라이언트 코드를 간단하게 만듭니다.
 */
public class OrderFacade {

    private final InventoryService inventoryService = new InventoryService();
    private final BillingService billingService = new BillingService();
    private final ShippingService shippingService = new ShippingService();

    public String placeOrder(String orderNo, String productId, int amount) {
        String reserved = inventoryService.reserve(productId);
        String charged = billingService.charge(orderNo, amount);
        String shipped = shippingService.requestDelivery(orderNo);

        return reserved + " / " + charged + " / " + shipped;
    }
}
