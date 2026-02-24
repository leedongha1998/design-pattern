package com.library.patterns.facade;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade 패턴의 핵심 클래스입니다.
 */
public class OrderFacade {

    private final InventoryService inventoryService = new InventoryService();
    private final BillingService billingService = new BillingService();
    private final ShippingService shippingService = new ShippingService();

    public PlaceOrderResult placeOrder(PlaceOrderCommand command) {
        long startedAt = System.currentTimeMillis();
        List<FacadeStepResult> steps = new ArrayList<>();

        try {
            steps.add(runStep("inventory", () -> inventoryService.reserve(command.productId())));
            steps.add(runStep("billing", () -> billingService.charge(command.orderNo(), command.amount())));
            steps.add(runStep("shipping", () -> shippingService.requestDelivery(command.orderNo())));

            return new PlaceOrderResult(
                    true,
                    command.orderNo(),
                    command.traceId(),
                    "",
                    "",
                    false,
                    System.currentTimeMillis() - startedAt,
                    steps
            );
        } catch (IllegalArgumentException e) {
            return failedResult(command, startedAt, steps, "VALIDATION_ERROR", false);
        } catch (RuntimeException e) {
            String failedAt = steps.size() == 0 ? "inventory" : steps.size() == 1 ? "billing" : "shipping";
            return new PlaceOrderResult(
                    false,
                    command.orderNo(),
                    command.traceId(),
                    failedAt,
                    "SUBSYSTEM_FAILURE",
                    true,
                    System.currentTimeMillis() - startedAt,
                    steps
            );
        }
    }

    private PlaceOrderResult failedResult(
            PlaceOrderCommand command,
            long startedAt,
            List<FacadeStepResult> steps,
            String errorCode,
            boolean retryable
    ) {
        return new PlaceOrderResult(
                false,
                command.orderNo(),
                command.traceId(),
                "validation",
                errorCode,
                retryable,
                System.currentTimeMillis() - startedAt,
                steps
        );
    }

    private FacadeStepResult runStep(String step, StepCall call) {
        long startedAt = System.currentTimeMillis();
        String detail = call.execute();
        return new FacadeStepResult(step, true, detail, System.currentTimeMillis() - startedAt);
    }

    @FunctionalInterface
    private interface StepCall {
        String execute();
    }
}
