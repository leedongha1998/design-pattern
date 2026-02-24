import { DashboardContainer } from './patterns/container-presentational';
import { Card, CardBody, CardFooter, CardHeader } from './patterns/compound-component';
import { FeatureToggle } from './patterns/render-props';
import { withLoading } from './patterns/hoc-with-loading';
import { ThemeProvider, useTheme } from './patterns/provider-context';
import { useDebounce } from './hooks/useDebounce';
import { useState } from 'react';

/**
 * HOC 패턴으로 감싼 컴포넌트 예시입니다.
 */
const ProfilePanel = withLoading(({ name }: { name: string }) => <p>사용자: {name}</p>);

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
  const [value, setValue] = useState('');
  const debounced = useDebounce(value, 500);

  return (
    <div>
      <h3>Custom Hook 패턴 (useDebounce)</h3>
      <input
        value={value}
        onChange={(e) => setValue(e.target.value)}
        placeholder="검색어 입력"
      />
      <p>실시간 값: {value}</p>
      <p>디바운스 값: {debounced}</p>
    </div>
  );
}

/**
 * Root demo component that composes multiple React design-pattern examples.
 *
 * @returns The component tree demonstrating container/presentational, compound components, render props, higher-order components, context/provider usage, and a debounced input example.
 */
export function App() {
  return (
    <ThemeProvider>
      <div style={{ padding: 24, fontFamily: 'sans-serif' }}>
        <h1>React + TypeScript 디자인 패턴 예제</h1>

        <section>
          <h2>1) Container / Presentational</h2>
          <DashboardContainer />
        </section>

        <section>
          <h2>2) Compound Component</h2>
          <Card>
            <CardHeader title="주문 카드" />
            <CardBody>주문 본문 내용을 렌더링합니다.</CardBody>
            <CardFooter>푸터 액션 영역</CardFooter>
          </Card>
        </section>

        <section>
          <h2>3) Render Props</h2>
          <FeatureToggle
            feature="betaBanner"
            renderOn={() => <p>베타 배너 ON</p>}
            renderOff={() => <p>베타 배너 OFF</p>}
          />
        </section>

        <section>
          <h2>4) HOC (Higher-Order Component)</h2>
          <ProfilePanel loading={false} name="홍길동" />
        </section>

        <section>
          <h2>5) Provider / Context</h2>
          <ThemeBadge />
        </section>

        <section>
          <DebounceExample />
        </section>
      </div>
    </ThemeProvider>
  );
}
