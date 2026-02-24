import { useEffect, useMemo, useState } from 'react';
import { OrderListView } from './OrderListView';
import type { Order, OrderStatus } from './types';

/**
 * [Container / Presentational]
 *
 * 실무에서 자주 마주치는 문제:
 * - 한 컴포넌트가 API 호출 + 필터 + 정렬 + 렌더링을 모두 처리해 비대해짐
 * - UI 변경과 비즈니스 로직 변경이 서로 충돌해 유지보수 비용 증가
 *
 * 해결 방식:
 * - Container는 "데이터 준비/가공/액션"만 담당
 * - View(Presentational)는 "렌더링"만 담당
 *
 * 이 컴포넌트의 역할:
 * 1) 초기 주문 데이터를 로딩한다.
 * 2) 선택된 상태값으로 필터링한다.
 * 3) 가공된 결과와 이벤트 핸들러를 View로 전달한다.
 */
export function DashboardContainer() {
  const [orders, setOrders] = useState<Order[]>([]);
  const [selectedStatus, setSelectedStatus] = useState<OrderStatus | 'ALL'>('ALL');

  useEffect(() => {
    // 실무에서는 React Query/SWR + API Client로 대체
    setOrders([
      { id: 'ORD-1001', customerName: 'Kim', status: 'PAID', totalAmount: 32000, paidAt: '2026-01-01' },
      { id: 'ORD-1002', customerName: 'Lee', status: 'SHIPPED', totalAmount: 54000, paidAt: '2026-01-02' },
      { id: 'ORD-1003', customerName: 'Park', status: 'CANCELLED', totalAmount: 12000, paidAt: '2026-01-03' }
    ]);
  }, []);

  const filteredOrders = useMemo(() => {
    if (selectedStatus === 'ALL') return orders;
    return orders.filter((order) => order.status === selectedStatus);
  }, [orders, selectedStatus]);

  return (
    <OrderListView
      orders={filteredOrders}
      selectedStatus={selectedStatus}
      onSelectStatus={setSelectedStatus}
    />
  );
}
