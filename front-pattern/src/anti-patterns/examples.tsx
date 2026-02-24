import { Dispatch, SetStateAction, useState } from 'react';

/**
 * 안티패턴 예시 1:
 * 데이터 조회와 UI 렌더링을 하나의 컴포넌트에서 모두 처리해
 * 테스트/재사용/유지보수가 어려워지는 형태입니다.
 */
export function MixedDashboardAntiPattern() {
  const [orders] = useState([
    { id: 'ORD-1001', status: 'PAID' },
    { id: 'ORD-1002', status: 'SHIPPED' }
  ]);

  return (
    <div>
      <h4>Container/Presentational 미적용</h4>
      <ul>
        {orders.map((order) => (
          <li key={order.id}>
            {order.id} - {order.status}
          </li>
        ))}
      </ul>
    </div>
  );
}

/**
 * 안티패턴 예시 2:
 * 전역으로 공유할 값을 props drilling으로 깊게 전달하는 형태입니다.
 */
export function PropsDrillingAntiPattern() {
  const [theme, setTheme] = useState<'light' | 'dark'>('light');
  return <LevelOne theme={theme} setTheme={setTheme} />;
}

function LevelOne({
  theme,
  setTheme
}: {
  theme: 'light' | 'dark';
  setTheme: Dispatch<SetStateAction<'light' | 'dark'>>;
}) {
  return <LevelTwo theme={theme} setTheme={setTheme} />;
}

function LevelTwo({
  theme,
  setTheme
}: {
  theme: 'light' | 'dark';
  setTheme: Dispatch<SetStateAction<'light' | 'dark'>>;
}) {
  return (
    <div>
      <h4>Provider/Context 미적용 (props drilling)</h4>
      <p>현재 테마: {theme}</p>
      <button onClick={() => setTheme((prev) => (prev === 'light' ? 'dark' : 'light'))}>토글</button>
    </div>
  );
}

/**
 * 안티패턴 예시 3:
 * 중복되는 디바운스 로직을 각 컴포넌트마다 복붙하는 형태입니다.
 */
export function DuplicatedDebounceAntiPattern() {
  const [keyword, setKeyword] = useState('');
  const [debounced, setDebounced] = useState('');

  const onChange = (value: string) => {
    setKeyword(value);
    setTimeout(() => {
      setDebounced(value);
    }, 500);
  };

  return (
    <div>
      <h4>Custom Hook 미적용 (로직 중복)</h4>
      <input value={keyword} onChange={(e) => onChange(e.target.value)} />
      <p>디바운스 값: {debounced}</p>
    </div>
  );
}
