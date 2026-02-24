package com.library;

import com.library.patterns.factory.NotificationFactoryDemo;
import com.library.patterns.observer.OrderEventObserverDemo;
import com.library.patterns.proxy.CachedProductServiceDemo;
import com.library.patterns.strategy.PaymentStrategyDemo;
import com.library.patterns.template.OrderTemplateDemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 스프링부트 애플리케이션 시작점입니다.
 *
 * <p>앱이 실행되면 CommandLineRunner를 통해 각 디자인 패턴 예제를 순서대로 실행합니다.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * 부팅 완료 후 디자인 패턴 데모를 실행합니다.
     */
    @Bean
    CommandLineRunner runPatternDemos(
            PaymentStrategyDemo paymentStrategyDemo,
            NotificationFactoryDemo notificationFactoryDemo,
            OrderTemplateDemo orderTemplateDemo,
            OrderEventObserverDemo orderEventObserverDemo,
            CachedProductServiceDemo cachedProductServiceDemo
    ) {
        return args -> {
            System.out.println("\n=== 1) Strategy Pattern ===");
            paymentStrategyDemo.run();

            System.out.println("\n=== 2) Factory Method Pattern ===");
            notificationFactoryDemo.run();

            System.out.println("\n=== 3) Template Method Pattern ===");
            orderTemplateDemo.run();

            System.out.println("\n=== 4) Observer Pattern ===");
            orderEventObserverDemo.run();

            System.out.println("\n=== 5) Proxy Pattern ===");
            cachedProductServiceDemo.run();
        };
    }
}
