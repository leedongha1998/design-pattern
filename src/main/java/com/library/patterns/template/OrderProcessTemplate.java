package com.library.patterns.template;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Template Method 패턴의 추상 클래스입니다.
 */
public abstract class OrderProcessTemplate {

    public final OrderProcessResult process(OrderContext context) {
        long startedAt = System.currentTimeMillis();
        List<TemplateStepResult> steps = new ArrayList<>();

        try {
            beforeProcess(context);
            steps.add(runStep("validate", () -> { validate(context); return "validated"; }));
            steps.add(runStep("pay", () -> pay(context)));
            steps.add(runStep("prepareDelivery", () -> prepareDelivery(context)));
            afterProcess(context);

            return new OrderProcessResult(
                    context.orderNo(),
                    context.traceId(),
                    true,
                    "",
                    false,
                    System.currentTimeMillis() - startedAt,
                    steps
            );
        } catch (IllegalArgumentException e) {
            return new OrderProcessResult(
                    context.orderNo(),
                    context.traceId(),
                    false,
                    "VALIDATION_ERROR",
                    false,
                    System.currentTimeMillis() - startedAt,
                    steps
            );
        } catch (RuntimeException e) {
            return new OrderProcessResult(
                    context.orderNo(),
                    context.traceId(),
                    false,
                    "PROCESSING_ERROR",
                    true,
                    System.currentTimeMillis() - startedAt,
                    steps
            );
        }
    }

    protected void beforeProcess(OrderContext context) {
        // hook
    }

    protected void afterProcess(OrderContext context) {
        // hook
    }

    protected void validate(OrderContext context) {
        if (context.orderNo() == null || context.orderNo().isBlank()) {
            throw new IllegalArgumentException("주문번호가 비어 있습니다.");
        }
        if (context.amount() == null || context.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
        }
    }

    protected abstract String pay(OrderContext context);

    protected abstract String prepareDelivery(OrderContext context);

    private TemplateStepResult runStep(String step, StepExecutor executor) {
        long startedAt = System.currentTimeMillis();
        String detail = executor.execute();
        return new TemplateStepResult(step, true, detail, System.currentTimeMillis() - startedAt);
    }

    @FunctionalInterface
    private interface StepExecutor {
        String execute();
    }
}
