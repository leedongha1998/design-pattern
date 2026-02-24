import { ComponentType } from 'react';

/**
 * HOC 패턴:
 * 기존 컴포넌트를 감싸 공통 로직(로딩 표시)을 재사용합니다.
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
