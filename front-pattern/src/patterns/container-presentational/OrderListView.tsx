import type { Order, OrderStatus } from './types';

/**
 * Presentational View
 * - props를 받아 그리기만 한다.
 * - 비즈니스 규칙(필터/정렬/요청)은 알지 못한다.
 */
export function OrderListView({
  orders,
  selectedStatus,
  onSelectStatus
}: {
  orders: Order[];
  selectedStatus: OrderStatus | 'ALL';
  onSelectStatus: (status: OrderStatus | 'ALL') => void;
}) {
  return (
    <div style={{ border: '1px solid #ddd', borderRadius: 8, padding: 12 }}>
      <div style={{ display: 'flex', gap: 8, marginBottom: 12 }}>
        {(['ALL', 'PAID', 'SHIPPED', 'CANCELLED'] as const).map((status) => (
          <button key={status} onClick={() => onSelectStatus(status)}>
            {status}
            {selectedStatus === status ? ' ✅' : ''}
          </button>
        ))}
      </div>

      <table width="100%" cellPadding={6}>
        <thead>
          <tr>
            <th align="left">주문번호</th>
            <th align="left">고객</th>
            <th align="left">상태</th>
            <th align="right">금액</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <tr key={order.id}>
              <td>{order.id}</td>
              <td>{order.customerName}</td>
              <td>{order.status}</td>
              <td align="right">{order.totalAmount.toLocaleString()}원</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
