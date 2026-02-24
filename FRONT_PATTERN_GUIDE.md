# Front-end Pattern 학습 가이드

`front-pattern` 패키지는 React + TypeScript로 실무에서 자주 접하는 UI 아키텍처 패턴을 작은 예제로 보여줍니다.

- 소스 위치: `front-pattern/src`
- 엔트리: `front-pattern/src/App.tsx`

## 왜 필요한가?

백엔드 패턴(Strategy, Factory 등)과 달리 프론트엔드에서는
- 상태 전파,
- UI 조합,
- 공통 로직 재사용
문제가 더 자주 발생합니다.

그래서 아래 패턴들을 먼저 익히는 것이 실무 생산성에 직접적입니다.

1. Container / Presentational
2. Compound Component
3. Render Props
4. HOC
5. Provider/Context
6. Custom Hook

## 추천 학습 순서

1. Container / Presentational
2. Provider/Context
3. Custom Hook
4. Compound Component
5. HOC
6. Render Props

> 실제 프로젝트에서는 Render Props보다 Hook/HOC/Compound 조합을 더 많이 보게 됩니다.
