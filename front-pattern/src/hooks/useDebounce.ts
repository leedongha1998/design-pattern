import { useEffect, useState } from 'react';

/**
 * Create a debounced version of a value that updates only after the value has remained unchanged for a given delay.
 *
 * @param value - The input value to debounce
 * @param delay - Delay in milliseconds to wait after the last change before updating the returned value
 * @returns The debounced value which reflects `value` only after it has remained unchanged for `delay` milliseconds
 */
export function useDebounce<T>(value: T, delay: number) {
  const [debounced, setDebounced] = useState(value);

  useEffect(() => {
    const timer = setTimeout(() => setDebounced(value), delay);
    return () => clearTimeout(timer);
  }, [value, delay]);

  return debounced;
}
