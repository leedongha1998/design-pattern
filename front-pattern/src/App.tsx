import { useState } from 'react';
import { DashboardContainer } from './patterns/container-presentational';
import { Card } from './patterns/compound-component';
import { FeatureToggle } from './patterns/render-props';
import { withRequestBoundary } from './patterns/hoc-with-loading';
import { ThemeProvider, useTheme } from './patterns/provider-context';
import { useDebounce } from './hooks/search/useDebounce';
import {
  DuplicatedDebounceAntiPattern,
  MixedDashboardAntiPattern,
  PropsDrillingAntiPattern
} from './anti-patterns/examples';

/**
 * HOC 적용 예시:
 * - 프로필 본문은 순수 UI
 * - 로딩/에러 UI는 HOC가 담당
 */
const ProfilePanel = withRequestBoundary(({ name }: { name: string }) => <p>사용자: {name}</p>);

/**
 * Displays the current theme and a control to toggle it.
 *
 * Renders a horizontal row showing a label, the current theme value from theme context, and a button that switches the theme when clicked.
 *
 * @returns A JSX element containing the current theme label, the theme value, and a toggle button
 */
function ThemeBadge() {
  const { theme, toggleTheme } = useTheme();
  return (
    <div style={{ display: 'flex', gap: 8, alignItems: 'center' }}>
      <strong>현재 테마:</strong>
      <span>{theme}</span>
      <button onClick={toggleTheme}>토글</button>
    </div>
  );
}

/**
 * Renders a demo UI that shows live and debounced input values using the `useDebounce` hook.
 *
 * @returns A JSX element containing a text input, the current (real-time) value, and the debounced value.
 */
function DebounceExample() {
  const [query, setQuery] = useState('');
  const debouncedQuery = useDebounce(query, 500);

  return (
    <div>
      <h3>Custom Hook (검색 디바운스)</h3>
      <input value={query} onChange={(e) => setQuery(e.target.value)} placeholder="상품 검색어 입력" />
      <p>입력값: {query}</p>
      <p>요청 기준값(디바운스): {debouncedQuery}</p>
    </div>
  );
}

export function App() {
  return (
    <ThemeProvider>
      <div style={{ padding: 24, fontFamily: 'sans-serif', display: 'grid', gap: 24 }}>
        <h1>React + TypeScript 실무형 패턴 예제</h1>

        <section>
          <h2>1) Container / Presentational</h2>
          <DashboardContainer />
        </section>

        <section>
          <h2>2) Compound Component</h2>
          <Card.Root tone="warning">
            <Card.Header title="결제 지연 경고" subtitle="상태 모니터링" />
            <Card.Body>최근 10분간 승인 지연률이 임계치를 초과했습니다.</Card.Body>
            <Card.Footer>대응: 결제사 헬스체크 및 서킷브레이커 상태 확인</Card.Footer>
          </Card.Root>
        </section>

        <section>
          <h2>3) Render Props</h2>
          <FeatureToggle
            feature="betaBanner"
            renderOn={() => <p>신규 배너 실험 ON</p>}
            renderOff={() => <p>신규 배너 실험 OFF</p>}
          />
        </section>

        <section>
          <h2>4) HOC (요청 상태 표준화)</h2>
          <ProfilePanel loading={false} name="홍길동" />
        </section>

        <section>
          <h2>5) Provider / Context</h2>
          <ThemeBadge />
        </section>

        <section>
          <h2>6) Custom Hook</h2>
          <DebounceExample />
        </section>

        <section>
          <h2>안티패턴 예제 (패턴 도입 이유)</h2>
          <MixedDashboardAntiPattern />
          <PropsDrillingAntiPattern />
          <DuplicatedDebounceAntiPattern />
        </section>
      </div>
    </ThemeProvider>
  );
}
