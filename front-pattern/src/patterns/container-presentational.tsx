import { useEffect, useState } from 'react';

interface Order {
  id: string;
  status: 'PAID' | 'SHIPPED';
}

/**
 * Presentational 컴포넌트:
 * 데이터 표시(UI) 역할만 담당합니다.
 */
function OrderListView({ orders }: { orders: Order[] }) {
  return (
    <ul>
      {orders.map((order) => (
        <li key={order.id}>
          {order.id} - {order.status}
        </li>
      ))}
    </ul>
  );
}

/**
 * Container 컴포넌트:
 * 데이터 준비/상태 관리/비즈니스 로직을 담당합니다.
 */
export function DashboardContainer() {
  const [orders, setOrders] = useState<Order[]>([]);

  useEffect(() => {
    // 실무에서는 API 호출로 대체됩니다.
    setOrders([
      { id: 'ORD-1001', status: 'PAID' },
      { id: 'ORD-1002', status: 'SHIPPED' }
    ]);
  }, []);

  return <OrderListView orders={orders} />;
}
