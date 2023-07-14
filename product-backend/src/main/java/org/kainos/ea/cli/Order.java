package org.kainos.ea.cli;

import java.util.Date;

public class Order {
    private int orderId;
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    private String customerName;

    public Order(int orderId, String customerName, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
    }

    private Date orderDate;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate.toLocaleString();
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}


