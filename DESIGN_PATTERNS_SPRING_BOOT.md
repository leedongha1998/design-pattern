# 스프링부트 실무형 디자인 패턴 학습 가이드

이 문서는 `src/main/java/com/library/patterns` 아래 예제 코드가 어떤 패턴을 보여주는지 빠르게 이해할 수 있도록 정리한 문서입니다.

## 1. Strategy 패턴
- **패키지**: `com.library.patterns.strategy`
- **핵심 아이디어**: 알고리즘(여기서는 결제 방식)을 인터페이스로 분리하고, 런타임에 교체합니다.

## 2. Factory Method 패턴
- **패키지**: `com.library.patterns.factory`
- **핵심 아이디어**: 객체 생성 책임을 하위 클래스에 위임합니다.

## 3. Template Method 패턴
- **패키지**: `com.library.patterns.template`
- **핵심 아이디어**: 알고리즘의 큰 흐름은 상위 클래스에 고정하고, 일부 단계만 하위에서 구현합니다.

## 4. Observer 패턴
- **패키지**: `com.library.patterns.observer`
- **핵심 아이디어**: 한 객체의 상태 변경을 여러 구독자에게 자동 전파합니다.

## 5. Proxy 패턴
- **패키지**: `com.library.patterns.proxy`
- **핵심 아이디어**: 실제 객체 접근 전후에 부가 기능(캐시, 권한, 로깅)을 끼워 넣습니다.

## 6. Decorator 패턴
- **패키지**: `com.library.patterns.decorator`
- **핵심 아이디어**: 기존 객체를 수정하지 않고 기능을 레이어처럼 덧붙입니다.
- **예제 의도**:
  - `BasicNotifier`를 기본으로 두고,
  - `SlackDecorator`, `SmsDecorator`를 조합해 부가 기능이 누적되는 흐름을 보여줍니다.

## 7. Adapter 패턴
- **패키지**: `com.library.patterns.adapter`
- **핵심 아이디어**: 호환되지 않는 인터페이스를 중간 어댑터로 맞춰 연결합니다.
- **예제 의도**:
  - 신규 서비스가 요구하는 `PaymentPort`와
  - 기존 모듈 `LegacyPaymentClient`를 `LegacyPaymentAdapter`로 연결합니다.

## 8. Facade 패턴
- **패키지**: `com.library.patterns.facade`
- **핵심 아이디어**: 복잡한 하위 시스템 호출을 단일 진입점으로 단순화합니다.
- **예제 의도**:
  - 재고/결제/배송 서브시스템 호출을
  - `OrderFacade#placeOrder` 하나로 감싸 클라이언트 코드를 단순화합니다.

## 9. Chain of Responsibility 패턴
- **패키지**: `com.library.patterns.chain`
- **핵심 아이디어**: 요청을 단계별 처리자 체인으로 전달하며 처리합니다.
- **예제 의도**:
  - 팀장 → 부서장 → 임원 승인 체인으로
  - 금액별 승인/거절 분기를 분산 처리합니다.

---

## 디자인 패턴 공부 시 추가로 꼭 챙길 내용

1. **왜 이 패턴을 쓰는지(문제 상황) 먼저 정의하기**
2. **패턴 간 경계 구분하기** (Factory Method vs Abstract Factory, Decorator vs Proxy, Template Method vs Strategy)
3. **SOLID 원칙과 연결해서 보기**
4. **Spring이 이미 제공하는 패턴 찾기** (`@EventListener`, AOP Proxy, Filter 체인 등)
5. **테스트 가능성으로 설계 검증하기**
6. **안티패턴도 같이 학습하기**
7. **리팩터링 흐름으로 익히기**

---

## 추천 학습 순서
1. Strategy
2. Factory Method
3. Observer
4. Template Method
5. Proxy
6. Decorator
7. Adapter
8. Facade
9. Chain of Responsibility

---

## 실행 방법
```bash
./gradlew bootRun
```

실행하면 `Main`의 `CommandLineRunner`가 각 패턴 데모를 순서대로 출력합니다.
