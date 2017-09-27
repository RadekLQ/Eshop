package be.vdab.entiteiten;

import java.util.Comparator;

public class OrderDetail implements Comparable<OrderDetail> {
    private Integer orderDetailId;
    private Float amount;
    private Integer orderId;
    private Integer productId;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId, Float amount, Integer orderId, Integer productId) {
        this.orderDetailId = orderDetailId;
        this.amount = amount;
        this.orderId = orderId;
        this.productId = productId;
    }

    public static Comparator<OrderDetail> sortBasedOnOrderDetailId() {
        return Comparator.comparing(OrderDetail::getOrderDetailId);
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s", orderDetailId, "Amount:", amount, "OrderId:", orderId, "ProductId:", productId);
    }

    @Override
    public int compareTo(OrderDetail o) {
        return this.orderDetailId - o.orderDetailId;
    }
}
