package com.nsss.pizzamanagementsystembackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String customerName;
    private String address;
    private List<OrderItem> items;
    private double amount;
    private boolean deliveryAssigned;
    private String deliveryRider;
    private boolean delivered;

    public Order(String customerName, String address, String deliveryRider) {
        this.customerName = customerName;
        this.address = address;
        this.deliveryRider = deliveryRider;
    }

    public Order(String customerName, String address, boolean deliveryAssigned, String deliveryRider) {
        this.customerName = customerName;
        this.address = address;
        this.deliveryAssigned = deliveryAssigned;
        this.deliveryRider = deliveryRider;
    }

    @PersistenceConstructor
    public Order(String id, String customerName, String address, List<OrderItem> items, double amount, boolean deliveryAssigned, String deliveryRider, boolean delivered) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.items = items;
        this.amount = amount;
        this.deliveryAssigned = deliveryAssigned;
        this.deliveryRider = deliveryRider;
        this.delivered = delivered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isDeliveryAssigned() {
        return deliveryAssigned;
    }

    public void setDeliveryAssigned(boolean deliveryAssigned) {
        this.deliveryAssigned = deliveryAssigned;
    }

    public String getDeliveryRider() {
        return deliveryRider;
    }

    public void setDeliveryRider(String deliveryRider) {
        this.deliveryRider = deliveryRider;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
