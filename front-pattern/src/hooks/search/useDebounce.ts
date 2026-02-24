import { useEffect, useState } from 'react';

/**
 * 재사용 가능한 Debounce Hook
 * @param value 원본 입력값
 * @param delayMs 지연 시간(ms)
 */
export function useDebounce<T>(value: T, delayMs: number) {
  const [debounced, setDebounced] = useState(value);

  useEffect(() => {
    const timer = setTimeout(() => setDebounced(value), delayMs);
    return () => clearTimeout(timer);
  }, [value, delayMs]);

  return debounced;
}
