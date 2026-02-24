# Compound Component

## 실무 문제
- 모달/카드/드롭다운처럼 내부 영역이 많아 props가 비대해짐
- 한 컴포넌트에 모든 슬롯을 props로 받다 보면 사용성이 나빠짐

## 해결
- `Card.Root`, `Card.Header`, `Card.Body`, `Card.Footer`처럼 조합형 API 제공
- 컨텍스트로 하위 컴포넌트에 공통 상태 전달
