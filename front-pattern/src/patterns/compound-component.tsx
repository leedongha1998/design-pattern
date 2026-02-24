import { PropsWithChildren } from 'react';

/**
 * Container component for a card that groups header, body, and footer content.
 *
 * @param children - The card contents; typically composed of CardHeader, CardBody, and CardFooter elements
 * @returns A div element that wraps `children` with a light border and padding
 */
export function Card({ children }: PropsWithChildren) {
  return <div style={{ border: '1px solid #ddd', padding: 12 }}>{children}</div>;
}

/**
 * Renders a level-3 heading with the provided title.
 *
 * @param title - The text displayed inside the <h3> heading.
 * @returns A React element: an `<h3>` containing `title`.
 */
export function CardHeader({ title }: { title: string }) {
  return <h3>{title}</h3>;
}

/**
 * Container for a card's body content.
 *
 * @param children - Elements to render inside the card body
 * @returns The rendered card body element
 */
export function CardBody({ children }: PropsWithChildren) {
  return <div>{children}</div>;
}

/**
 * Renders children wrapped in a `small` element to serve as a card footer.
 *
 * @returns A React element containing `children` wrapped in a `small` element.
 */
export function CardFooter({ children }: PropsWithChildren) {
  return <small>{children}</small>;
}
