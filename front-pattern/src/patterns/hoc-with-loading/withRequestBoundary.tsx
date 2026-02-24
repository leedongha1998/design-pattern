import { ComponentType } from 'react';

interface RequestBoundaryProps {
  loading: boolean;
  errorMessage?: string;
}

/**
 * [HOC: withRequestBoundary]
 *
 * 실무에서 자주 마주치는 문제:
 * - 화면마다 로딩/에러 UI를 반복 구현
 * - 성공 상태 UI와 요청 상태 UI가 섞여 가독성 저하
 *
 * 해결 방식:
 * - HOC로 요청 상태 렌더링을 공통화
 * - 원본 컴포넌트는 "정상 데이터 UI"만 신경 쓰도록 분리
 */
export function withRequestBoundary<P extends object>(Wrapped: ComponentType<P>) {
  return function EnhancedComponent(props: P & RequestBoundaryProps) {
    const { loading, errorMessage, ...rest } = props;

    if (loading) return <p>데이터 로딩 중...</p>;
    if (errorMessage) return <p style={{ color: 'crimson' }}>오류: {errorMessage}</p>;

    return <Wrapped {...(rest as P)} />;
  };
}
