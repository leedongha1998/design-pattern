import { useEffect, useState } from 'react';

/**
 * [Custom Hook: useDebounce]
 *
 * 실무에서 자주 마주치는 문제:
 * - 검색창 입력마다 API 요청이 발생해 트래픽/비용/깜빡임 증가
 *
 * 해결 방식:
 * - 마지막 입력 후 delayMs가 지나면 값 반영
 * - UI 입력값과 요청 트리거 값을 분리
 */
export function useDebounce<T>(value: T, delayMs: number) {
  const [debounced, setDebounced] = useState(value);

  useEffect(() => {
    const timer = setTimeout(() => setDebounced(value), delayMs);
    return () => clearTimeout(timer);
  }, [value, delayMs]);

  return debounced;
}
