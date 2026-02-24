# 스프링부트 실무형 디자인 패턴 학습 가이드

이 문서는 `src/main/java/com/library/patterns` 아래 예제 코드가 어떤 패턴을 보여주는지 빠르게 이해할 수 있도록 정리한 문서입니다.

## 1. Strategy 패턴
- **패키지**: `com.library.patterns.strategy`
- **핵심 아이디어**: 알고리즘(여기서는 결제 방식)을 인터페이스로 분리하고, 런타임에 교체합니다.
- **언제 도입하면 좋은가?**
  - 동일한 유스케이스에서 정책(수수료/승인/할인/정렬)이 자주 바뀔 때
  - `if-else`/`switch` 분기가 결제수단, 고객등급, 지역조건으로 계속 늘어날 때
  - A/B 테스트나 테넌트별 정책 분리가 필요할 때

## 2. Factory Method 패턴
- **패키지**: `com.library.patterns.factory`
- **핵심 아이디어**: 객체 생성 책임을 하위 클래스에 위임합니다.
- **언제 도입하면 좋은가?**
  - 생성 대상이 채널/환경/플랜에 따라 달라질 때
  - 생성 직전 검증/초기화/기본값 주입 같은 공통 흐름이 필요할 때
  - 생성 로직 변경이 잦아 호출부 수정 비용을 줄이고 싶을 때

## 3. Template Method 패턴
- **패키지**: `com.library.patterns.template`
- **핵심 아이디어**: 알고리즘의 큰 흐름은 상위 클래스에 고정하고, 일부 단계만 하위에서 구현합니다.
- **언제 도입하면 좋은가?**
  - 처리 절차(검증→결제→후처리)는 같고 일부 단계만 채널별로 다를 때
  - 단계별 로깅/메트릭/예외 분류를 공통으로 강제하고 싶을 때
  - 서비스별 구현 편차로 운영 품질이 흔들리는 것을 막고 싶을 때

## 4. Observer 패턴
- **패키지**: `com.library.patterns.observer`
- **핵심 아이디어**: 한 객체의 상태 변경을 여러 구독자에게 자동 전파합니다.
- **언제 도입하면 좋은가?**
  - 주문 상태 변경 후 알림/감사로그/적립금 등 후속 작업이 여러 팀으로 퍼질 때
  - 핵심 트랜잭션 코드에서 부가 기능 결합을 줄이고 싶을 때
  - 구독자 추가/삭제를 배포 리스크 없이 유연하게 하고 싶을 때

## 5. Proxy 패턴
- **패키지**: `com.library.patterns.proxy`
- **핵심 아이디어**: 실제 객체 접근 전후에 부가 기능(캐시, 권한, 로깅)을 끼워 넣습니다.
- **언제 도입하면 좋은가?**
  - 원격 API/DB 호출이 비싸고 동일 조회가 반복될 때
  - 접근 제어, 레이트리밋, 감사 로깅 같은 횡단 관심사가 필요할 때
  - 장애 시 fallback(캐시/기본값) 전략을 호출부 밖에서 관리하고 싶을 때

## 6. Decorator 패턴
- **패키지**: `com.library.patterns.decorator`
- **핵심 아이디어**: 기존 객체를 수정하지 않고 기능을 레이어처럼 덧붙입니다.
- **언제 도입하면 좋은가?**
  - 알림 채널/검증/마스킹처럼 옵션 조합이 많아 상속 폭발이 날 때
  - 기능 on/off를 런타임 구성으로 바꾸고 싶을 때
  - 코어 구현체는 안정적으로 두고 확장만 빠르게 반복하고 싶을 때
- **예제 의도**:
  - `BasicNotifier`를 기본으로 두고,
  - `SlackDecorator`, `SmsDecorator`를 조합해 부가 기능이 누적되는 흐름을 보여줍니다.

## 7. Adapter 패턴
- **패키지**: `com.library.patterns.adapter`
- **핵심 아이디어**: 호환되지 않는 인터페이스를 중간 어댑터로 맞춰 연결합니다.
- **언제 도입하면 좋은가?**
  - 레거시/외부 SDK를 새 아키텍처 포트 인터페이스에 맞춰야 할 때
  - 교체 예정 시스템을 단계적으로 이전하고 싶을 때
  - 도메인 코드가 외부 의존 타입에 오염되는 것을 막고 싶을 때
- **예제 의도**:
  - 신규 서비스가 요구하는 `PaymentPort`와
  - 기존 모듈 `LegacyPaymentClient`를 `LegacyPaymentAdapter`로 연결합니다.

## 8. Facade 패턴
- **패키지**: `com.library.patterns.facade`
- **핵심 아이디어**: 복잡한 하위 시스템 호출을 단일 진입점으로 단순화합니다.
- **언제 도입하면 좋은가?**
  - 클라이언트가 재고/결제/배송 등 다수 서비스를 직접 오케스트레이션할 때
  - 단계별 실패 지점과 보상 처리 지점을 한 곳에서 통제해야 할 때
  - 팀 간 API 사용성을 단순화하고 변경 전파를 줄이고 싶을 때
- **예제 의도**:
  - 재고/결제/배송 서브시스템 호출을
  - `OrderFacade#placeOrder` 하나로 감싸 클라이언트 코드를 단순화합니다.

## 9. Chain of Responsibility 패턴
- **패키지**: `com.library.patterns.chain`
- **핵심 아이디어**: 요청을 단계별 처리자 체인으로 전달하며 처리합니다.
- **언제 도입하면 좋은가?**
  - 승인/검증 규칙이 단계적으로 누적되고 조직 변경이 잦을 때
  - 규칙 추가 시 기존 코드 수정 없이 핸들러만 추가하고 싶을 때
  - 처리 책임을 역할별로 분리해 감사 추적을 명확히 남겨야 할 때
- **예제 의도**:
  - 팀장 → 부서장 → 임원 승인 체인으로
  - 금액별 승인/거절 분기를 분산 처리합니다.

---


## 패키지별 분리 학습 방법 (추천)

학습 시에는 각 패턴 패키지의 `package-info.java`를 먼저 읽고, 그 다음 데모 클래스를 실행 흐름 기준으로 따라가세요.

- `strategy/package-info.java` → `PaymentStrategyDemo` → `CheckoutService`
- `factory/package-info.java` → `NotificationFactoryDemo` → `NotificationCreator`
- `template/package-info.java` → `OrderTemplateDemo` → `OrderProcessTemplate`
- `observer/package-info.java` → `OrderEventObserverDemo` → `OrderEventPublisher`
- `proxy/package-info.java` → `CachedProductServiceDemo` → `CachedProductServiceProxy`
- `decorator/package-info.java` → `DecoratorPatternDemo` → 각 Decorator 조합
- `adapter/package-info.java` → `AdapterPatternDemo` → `LegacyPaymentAdapter`
- `facade/package-info.java` → `FacadePatternDemo` → `OrderFacade`
- `chain/package-info.java` → `ChainOfResponsibilityDemo` → 각 ApprovalHandler

각 `package-info.java`에는 아래가 주석으로 정리되어 있습니다.
1) 언제 도입하는지
2) 실제 코드 실행 순서
3) 학습 시 봐야 할 핵심 포인트

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

---

## Front-end 패턴 학습 패키지

백엔드 예제와 별도로 React + TypeScript 기반 프론트엔드 패턴 예제는 `front-pattern` 패키지에서 학습할 수 있습니다.

- 주요 패턴: Container/Presentational, Compound Component, Render Props, HOC, Provider/Context, Custom Hook
- 상세 문서: `FRONT_PATTERN_GUIDE.md`, `front-pattern/README.md`
