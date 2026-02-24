# Front-end 디자인 패턴 안티패턴 가이드

이 문서는 `front-pattern`에서 구현한 패턴 예제를 기준으로,
"패턴을 도입하지 않았을 때 발생하는 문제"를 함께 설명합니다.

## 1) Container / Presentational 패턴을 왜 도입하는가?

### 안티패턴
- 데이터 조회/가공/렌더링이 하나의 컴포넌트에 섞여 있는 구조
- 예시: `MixedDashboardAntiPattern`

### 문제점
- UI 변경이 데이터 로직 변경으로 쉽게 전파됨
- 단위 테스트에서 관심사가 섞여 테스트가 무거워짐
- 재사용이 어려워짐

### 패턴 도입 효과
- Container는 데이터/상태를 담당하고,
- Presentational은 화면 렌더링에 집중하도록 분리 가능

---

## 2) Provider / Context 패턴을 왜 도입하는가?

### 안티패턴
- 전역 상태를 여러 depth의 props로 전달(props drilling)
- 예시: `PropsDrillingAntiPattern`

### 문제점
- 중간 컴포넌트가 실제로 쓰지 않는 props를 계속 전달
- 구조가 깊어질수록 유지보수 비용 증가
- 상태 전달 경로가 복잡해져 버그 원인 추적이 어려움

### 패턴 도입 효과
- Context로 공유 상태를 필요한 컴포넌트에서 직접 소비
- 컴포넌트 간 결합도 감소

---

## 3) Custom Hook 패턴을 왜 도입하는가?

### 안티패턴
- 동일한 상태/이펙트 로직을 컴포넌트마다 복붙
- 예시: `DuplicatedDebounceAntiPattern`

### 문제점
- 버그 수정 시 여러 곳을 함께 고쳐야 함
- 로직 일관성이 깨지기 쉬움
- 가독성이 떨어짐

### 패턴 도입 효과
- 공통 로직을 Hook(`useDebounce`)으로 추상화
- 재사용성과 테스트 용이성 향상

---

## 소스 연결
- 안티패턴 예제 코드: `front-pattern/src/anti-patterns/examples.tsx`
- 패턴 적용 코드: `front-pattern/src/patterns/*`, `front-pattern/src/hooks/useDebounce.ts`
