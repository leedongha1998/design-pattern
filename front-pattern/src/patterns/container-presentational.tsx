import { useEffect, useState } from 'react';

interface Order {
  id: string;
  status: 'PAID' | 'SHIPPED';
}

/**
 * Renders an unordered list of orders.
 *
 * @param orders - Array of orders to display; each order should include `id` and `status`
 * @returns A React element: an unordered list where each order is rendered as "id - status"
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
 * Prepare and manage dashboard order data and render the OrderListView.
 *
 * Initializes local order state and populates it with sample orders on mount
 * (placeholder for an API call), then renders the presentational OrderListView
 * with the current orders.
 *
 * @returns The dashboard container element that renders OrderListView with the prepared orders.
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
