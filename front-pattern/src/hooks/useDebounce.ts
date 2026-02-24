import { useEffect, useState } from 'react';

/**
 * Custom Hook 패턴:
 * 반복되는 상태/효과 로직(디바운스)을 훅으로 분리합니다.
 */
export function useDebounce<T>(value: T, delay: number) {
  const [debounced, setDebounced] = useState(value);

  useEffect(() => {
    const timer = setTimeout(() => setDebounced(value), delay);
    return () => clearTimeout(timer);
  }, [value, delay]);

  return debounced;
}
