/**
 * [Render Props]
 *
 * 실무에서 자주 마주치는 문제:
 * - "로직은 같은데 UI만 다른" 요구가 반복됨 (A/B 테스트, 권한별 노출)
 *
 * 해결 방식:
 * - 플래그 판정 로직은 여기서 담당
 * - 실제 ON/OFF UI는 부모가 render function으로 주입
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
