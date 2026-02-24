# 스프링부트 실무형 디자인 패턴 학습 가이드

이 문서는 `src/main/java/com/library/patterns` 아래 예제 코드가 어떤 패턴을 보여주는지 빠르게 이해할 수 있도록 정리한 문서입니다.

## 1. Strategy 패턴
- **패키지**: `com.library.patterns.strategy`
- **핵심 아이디어**: 알고리즘(여기서는 결제 방식)을 인터페이스로 분리하고, 런타임에 교체합니다.
- **예제 의도**:
    - `PaymentStrategy` 인터페이스를 기준으로
    - `CardPaymentStrategy`, `KakaoPayStrategy`를 쉽게 바꿔 끼우는 흐름을 보여줍니다.
    - `CheckoutService`는 전략만 받아 실행하므로 결제 방식이 늘어나도 서비스 코드 변경이 최소화됩니다.
- **실무에서 자주 쓰는 이유**:
    - PG사 추가, 결제 정책 변경이 잦은 도메인에 유리합니다.

## 2. Factory Method 패턴
- **패키지**: `com.library.patterns.factory`
- **핵심 아이디어**: 객체 생성 책임을 하위 클래스에 위임합니다.
- **예제 의도**:
    - `NotificationCreator`가 공통 흐름(`notifyUser`)을 유지하고,
    - `EmailNotificationCreator`, `SmsNotificationCreator`가 실제 생성(`createSender`)을 담당합니다.
- **실무에서 자주 쓰는 이유**:
    - 채널(메일, 문자, 푸시) 확장 시 생성 로직이 복잡해질 때 구조를 안정적으로 유지할 수 있습니다.

## 3. Template Method 패턴
- **패키지**: `com.library.patterns.template`
- **핵심 아이디어**: 알고리즘의 큰 흐름은 상위 클래스에 고정하고, 일부 단계만 하위에서 구현합니다.
- **예제 의도**:
    - `OrderProcessTemplate#process`가 주문 처리 뼈대를 담당합니다.
    - `RegularOrderProcess`에서 결제/배송 준비 단계만 구체화합니다.
- **실무에서 자주 쓰는 이유**:
    - 주문, 정산, 배치 등 “절차는 같고 세부만 다른” 업무 로직에서 중복을 줄일 수 있습니다.

## 4. Observer 패턴
- **패키지**: `com.library.patterns.observer`
- **핵심 아이디어**: 한 객체의 상태 변경을 여러 구독자에게 자동 전파합니다.
- **예제 의도**:
    - `OrderEventPublisher`가 상태 변경 이벤트를 발행하고,
    - `SlackOrderListener`, `AuditOrderListener`가 각각 독립적으로 반응합니다.
- **실무에서 자주 쓰는 이유**:
    - 주문 상태 변경 시 알림, 감사 로그, 포인트 적립 등 후처리를 느슨하게 결합할 수 있습니다.

## 5. Proxy 패턴
- **패키지**: `com.library.patterns.proxy`
- **핵심 아이디어**: 실제 객체 접근 전후에 부가 기능(캐시, 권한, 로깅)을 끼워 넣습니다.
- **예제 의도**:
    - `CachedProductServiceProxy`가 `RealProductService` 앞단에서 캐시를 수행합니다.
    - 첫 조회는 MISS, 반복 조회는 HIT가 되도록 동작을 시각화했습니다.
- **실무에서 자주 쓰는 이유**:
    - 성능 최적화(캐시), 보안, 로깅, 트랜잭션 같은 횡단 관심사를 분리하기 좋습니다.

---

## 실행 방법
```bash
./gradlew bootRun
```

실행하면 `Main`의 `CommandLineRunner`가 각 패턴 데모를 순서대로 출력합니다.
