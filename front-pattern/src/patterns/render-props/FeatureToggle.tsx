/**
 * FeatureToggle
 * - 플래그 판정 로직만 담당
 * - 켜짐/꺼짐 UI는 부모에서 render function으로 주입
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
  // 실무에서는 LaunchDarkly/ConfigCat 등 원격 플래그와 연동
  const enabledMap = {
    betaBanner: true,
    newCheckout: false
  } satisfies Record<'betaBanner' | 'newCheckout', boolean>;

  return enabledMap[feature] ? renderOn() : renderOff();
}
