import { PropsWithChildren } from 'react';

/**
 * Compound Component 패턴:
 * Card 내부를 Header/Body/Footer로 조합해 사용합니다.
 */
export function Card({ children }: PropsWithChildren) {
  return <div style={{ border: '1px solid #ddd', padding: 12 }}>{children}</div>;
}

export function CardHeader({ title }: { title: string }) {
  return <h3>{title}</h3>;
}

export function CardBody({ children }: PropsWithChildren) {
  return <div>{children}</div>;
}

export function CardFooter({ children }: PropsWithChildren) {
  return <small>{children}</small>;
}
