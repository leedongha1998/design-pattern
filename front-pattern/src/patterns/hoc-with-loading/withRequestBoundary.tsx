import { ComponentType } from 'react';

interface RequestBoundaryProps {
  loading: boolean;
  errorMessage?: string;
}

/**
 * HOC: 데이터 요청 상태 UI를 공통 처리
 * - 로딩/에러 렌더를 표준화
 * - 비즈니스 컴포넌트는 "정상 상태 UI"에 집중
 */
export function withRequestBoundary<P extends object>(Wrapped: ComponentType<P>) {
  return function EnhancedComponent(props: P & RequestBoundaryProps) {
    const { loading, errorMessage, ...rest } = props;

    if (loading) return <p>데이터 로딩 중...</p>;
    if (errorMessage) return <p style={{ color: 'crimson' }}>오류: {errorMessage}</p>;

    return <Wrapped {...(rest as P)} />;
  };
}
