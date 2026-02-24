# front-pattern (React + TypeScript)

실무에서 자주 마주치는 프론트엔드 문제를 기준으로 디자인 패턴을 학습하는 예제 패키지입니다.

## 패키지 구조 (상황별 분리)

```text
src/
  patterns/
    container-presentational/
    compound-component/
    render-props/
    hoc-with-loading/
    provider-context/
  hooks/
    search/
```

각 패키지의 TS/TSX 파일 상단 주석에 아래를 직접 설명합니다.
1. 어떤 실무 문제를 해결하려는 패턴인지
2. 어떤 방식으로 적용하는지
3. 코드에서 핵심 역할이 무엇인지

## 포함된 패턴

1. **Container / Presentational**
   - 문제: UI와 데이터 로직이 한 컴포넌트에 섞여 비대해짐
   - 해결: Container는 오케스트레이션, View는 렌더링 전담
2. **Compound Component**
   - 문제: 카드/모달 슬롯 props가 비대해짐
   - 해결: `Root/Header/Body/Footer` 조합 API로 사용성 개선
3. **Render Props**
   - 문제: 로직은 같고 UI만 다른 요구(A/B, 권한)가 반복됨
   - 해결: 렌더 함수 주입으로 표현 분기
4. **HOC**
   - 문제: 로딩/에러 UI가 페이지마다 중복
   - 해결: HOC로 요청 상태 UI 표준화
5. **Provider / Context**
   - 문제: props drilling으로 전역 상태 전달이 복잡
   - 해결: Provider로 트리 전체 공유
6. **Custom Hook (`useDebounce`)**
   - 문제: 입력마다 API 호출되어 비용 증가
   - 해결: 디바운스 훅으로 요청 빈도 제어

## 실행 방법

```bash
cd front-pattern
npm install
npm run dev
```

## 안티패턴 학습

패턴 도입 배경을 함께 이해하려면 아래를 참고하세요.

- `FRONT_PATTERN_ANTI_PATTERN_GUIDE.md`
- `front-pattern/src/anti-patterns/examples.tsx`
