/**
 * Render Props 패턴:
 * 컴포넌트 내부 상태를 외부 렌더 함수를 통해 유연하게 표시합니다.
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
