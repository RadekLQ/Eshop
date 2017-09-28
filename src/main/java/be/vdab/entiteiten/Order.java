package be.vdab.entiteiten;

import java.util.Comparator;
import java.util.Date;

public class Order implements Comparable<Order> {

    private int orderId;
    private String paymentMethod;
    private int orderTotal;
    private Date date;
    private int customerId;
    private int eshopId;

    public Order() {
    }

    public Order(int orderId, String paymentMethod, int orderTotal, Date date, int customerId, int eshopId) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.orderTotal = orderTotal;
        this.date = date;
        this.customerId = customerId;
        this.eshopId = eshopId;
    }

    public static Comparator<Order> sortBasedOnOrderId() {
        return Comparator.comparing(Order::getOrderId);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEshopId() {
        return eshopId;
    }

    @Override
    public int compareTo(Order o) {
        return this.orderId - o.customerId;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s",
                orderId, "Payment method:", paymentMethod, "Order total:", orderTotal, "date:",
                date, "customer Id: ", customerId, "e-shop Id:", eshopId);
    }
}
