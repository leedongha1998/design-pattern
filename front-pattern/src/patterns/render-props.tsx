/**
 * Selects and renders one of two render callbacks based on the provided feature name.
 *
 * @param feature - The feature identifier to evaluate (`'betaBanner'` | `'newCheckout'`)
 * @param renderOn - Function that returns the JSX to render when the feature is enabled
 * @param renderOff - Function that returns the JSX to render when the feature is disabled
 * @returns The JSX element produced by the chosen render callback
 */
export function FeatureToggle({
  feature,
  renderOn,
  renderOff
}: {
  feature: 'betaBanner' | 'newCheckout';
  renderOn: () => JSX.Element;
  renderOff: () => JSX.Element;
}) {
  // 데모용 플래그(실무에서는 실험 플랫폼/원격 설정 사용)
  const enabled = feature === 'betaBanner';
  return enabled ? renderOn() : renderOff();
}
