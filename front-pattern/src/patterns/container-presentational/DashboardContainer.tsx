import { useEffect, useMemo, useState } from 'react';
import { OrderListView } from './OrderListView';
import type { Order, OrderStatus } from './types';

/**
 * Container Layer
 * - API 호출, 필터링, 정렬, 로딩/에러 상태를 담당
 * - UI 컴포넌트에는 가공된 데이터와 콜백만 전달
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
