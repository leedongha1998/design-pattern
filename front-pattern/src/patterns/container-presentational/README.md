# Container / Presentational

## 실무에서 자주 마주하는 문제
- UI 컴포넌트가 API 호출, 필터링, 정렬, 로딩/에러 상태까지 모두 처리해 비대해짐
- 디자이너와 협업하는 UI 수정이 비즈니스 로직 변경과 충돌함

## 도입 포인트
- **Container**: 데이터 로딩/상태/액션 담당
- **Presentational**: props 기반 렌더링만 담당

## 이 폴더 구성
- `types.ts`: 화면이 의존하는 도메인 타입
- `OrderListView.tsx`: 순수 UI
- `DashboardContainer.tsx`: 데이터 오케스트레이션
