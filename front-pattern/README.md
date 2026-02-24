# front-pattern (React + TypeScript)

실무에서 자주 사용하는 프론트엔드 디자인 패턴을 학습하기 위한 예제 패키지입니다.

## 포함된 패턴

1. **Container / Presentational**
   - 데이터 로직과 UI 렌더링 책임을 분리합니다.
2. **Compound Component**
   - 하나의 컴포넌트를 작은 조합 단위(Header/Body/Footer)로 구성합니다.
3. **Render Props**
   - 렌더링 방식을 함수로 주입받아 유연성을 높입니다.
4. **HOC (Higher-Order Component)**
   - 공통 로직(로딩 처리 등)을 래핑으로 재사용합니다.
5. **Provider / Context**
   - 전역 상태를 컴포넌트 트리에 전달합니다.
6. **Custom Hook**
   - 반복되는 상태/이펙트 로직을 훅으로 분리합니다.

## 실행 방법

```bash
cd front-pattern
npm install
npm run dev
```

## 학습 포인트

- 패턴은 "형태"가 아니라 "문제 해결 목적"으로 선택해야 합니다.
- 하나의 기능에 패턴을 과도하게 섞지 말고, 변경 가능성이 높은 지점을 중심으로 적용하세요.
