import { ComponentType } from 'react';

/**
 * Creates a higher-order component that displays a loading indicator and otherwise renders the wrapped component.
 *
 * @param Wrapped - The component to enhance with loading-state rendering.
 * @returns A component that accepts the wrapped component's props plus `loading: boolean`; when `loading` is `true` it renders a loading paragraph (`"로딩 중..."`), otherwise it renders `Wrapped` with the remaining props.
 */
export function withLoading<P extends object>(Wrapped: ComponentType<P>) {
  return function EnhancedComponent(props: P & { loading: boolean }) {
    const { loading, ...rest } = props;

    if (loading) {
      return <p>로딩 중...</p>;
    }

    return <Wrapped {...(rest as P)} />;
  };
}
