import { createContext, PropsWithChildren, useContext, useMemo, useState } from 'react';

type Theme = 'light' | 'dark';

interface ThemeContextValue {
  theme: Theme;
  toggleTheme: () => void;
}

const ThemeContext = createContext<ThemeContextValue | null>(null);

/**
 * Provides theme state and a toggle function to the component tree via ThemeContext.
 *
 * Renders a Context Provider that supplies the current `theme` and `toggleTheme` to descendants.
 *
 * @returns A React element that supplies `ThemeContext` to its children
 */
export function ThemeProvider({ children }: PropsWithChildren) {
  const [theme, setTheme] = useState<Theme>('light');

  const value = useMemo(
    () => ({
      theme,
      toggleTheme: () => setTheme((prev) => (prev === 'light' ? 'dark' : 'light'))
    }),
    [theme]
  );

  return <ThemeContext.Provider value={value}>{children}</ThemeContext.Provider>;
}

/**
 * Access the current theme context value.
 *
 * Throws an error if called outside a ThemeProvider.
 *
 * @returns The theme context value containing `theme` and `toggleTheme`.
 * @throws Error if `useTheme` is invoked outside of a `ThemeProvider`.
 */
export function useTheme() {
  const context = useContext(ThemeContext);
  if (!context) {
    throw new Error('useTheme must be used within ThemeProvider');
  }
  return context;
}
