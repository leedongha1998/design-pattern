package com.library;

import com.library.patterns.adapter.AdapterPatternDemo;
import com.library.patterns.chain.ChainOfResponsibilityDemo;
import com.library.patterns.common.DemoScenarioRunner;
import com.library.patterns.decorator.DecoratorPatternDemo;
import com.library.patterns.facade.FacadePatternDemo;
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
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runPatternDemos(
            DemoScenarioRunner scenarioRunner,
            PaymentStrategyDemo paymentStrategyDemo,
            NotificationFactoryDemo notificationFactoryDemo,
            OrderTemplateDemo orderTemplateDemo,
            OrderEventObserverDemo orderEventObserverDemo,
            CachedProductServiceDemo cachedProductServiceDemo,
            DecoratorPatternDemo decoratorPatternDemo,
            AdapterPatternDemo adapterPatternDemo,
            FacadePatternDemo facadePatternDemo,
            ChainOfResponsibilityDemo chainOfResponsibilityDemo
    ) {
        return args -> {
            System.out.println(scenarioRunner.runScenario("Strategy", paymentStrategyDemo::run));
            System.out.println(scenarioRunner.runScenario("Factory", notificationFactoryDemo::run));
            System.out.println(scenarioRunner.runScenario("Template", orderTemplateDemo::run));
            System.out.println(scenarioRunner.runScenario("Observer", orderEventObserverDemo::run));
            System.out.println(scenarioRunner.runScenario("Proxy", cachedProductServiceDemo::run));
            System.out.println(scenarioRunner.runScenario("Decorator", decoratorPatternDemo::run));
            System.out.println(scenarioRunner.runScenario("Adapter", adapterPatternDemo::run));
            System.out.println(scenarioRunner.runScenario("Facade", facadePatternDemo::run));
            System.out.println(scenarioRunner.runScenario("ChainOfResponsibility", chainOfResponsibilityDemo::run));
        };
    }
}
