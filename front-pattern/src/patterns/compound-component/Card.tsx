import { createContext, PropsWithChildren, useContext } from 'react';

interface CardContextValue {
  tone: 'default' | 'warning';
}

const CardContext = createContext<CardContextValue | null>(null);

/**
 * [Compound Component]
 *
 * 실무에서 자주 마주치는 문제:
 * - 카드/모달/드롭다운 같은 UI에서 props가 비대해짐
 * - 한 컴포넌트에 header/body/footer를 문자열 props로 억지 주입
 *
 * 해결 방식:
 * - Root/Header/Body/Footer 조합 API로 의도를 드러냄
 * - Root가 컨텍스트를 통해 하위 슬롯에 공통 상태 전달
 */
function Root({ children, tone = 'default' }: PropsWithChildren<{ tone?: 'default' | 'warning' }>) {
  return (
    <CardContext.Provider value={{ tone }}>
      <article
        style={{
          border: '1px solid #ddd',
          borderLeft: tone === 'warning' ? '6px solid #ff9800' : '1px solid #ddd',
          borderRadius: 8,
          padding: 12
        }}
      >
        {children}
      </article>
    </CardContext.Provider>
  );
}

function Header({ title, subtitle }: { title: string; subtitle?: string }) {
  return (
    <header style={{ marginBottom: 8 }}>
      <h3 style={{ margin: 0 }}>{title}</h3>
      {subtitle && <small>{subtitle}</small>}
    </header>
  );
}

function Body({ children }: PropsWithChildren) {
  const ctx = useContext(CardContext);
  return <div style={{ color: ctx?.tone === 'warning' ? '#8a4b00' : '#333' }}>{children}</div>;
}

function Footer({ children }: PropsWithChildren) {
  return <footer style={{ marginTop: 10, fontSize: 12 }}>{children}</footer>;
}

export const Card = { Root, Header, Body, Footer };
