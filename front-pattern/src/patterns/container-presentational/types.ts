export type OrderStatus = 'PAID' | 'SHIPPED' | 'CANCELLED';

export interface Order {
  id: string;
  customerName: string;
  status: OrderStatus;
  totalAmount: number;
  paidAt: string;
}
