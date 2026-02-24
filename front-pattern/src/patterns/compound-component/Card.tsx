import { createContext, PropsWithChildren, useContext } from 'react';

interface CardContextValue {
  tone: 'default' | 'warning';
}

const CardContext = createContext<CardContextValue | null>(null);

/**
 * Root가 공통 스타일/상태(tone)를 하위에 제공.
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
