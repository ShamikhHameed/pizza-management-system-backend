package com.nsss.pizzamanagementsystembackend.request;


import java.util.List;

public class OrderRequest {
    private String customerName;
    private String address;
    private List<OrderItemRequest> items;
//    private boolean deliveryAssigned;
    private String deliveryRider;

    public OrderRequest(String customerName, String address, List<OrderItemRequest> items, String deliveryRider) {
        this.customerName = customerName;
        this.address = address;
        this.items = items;
//        this.deliveryAssigned = deliveryAssigned;
        this.deliveryRider = deliveryRider;
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

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

    public String getDeliveryRider() {
        return deliveryRider;
    }

    public void setDeliveryRider(String deliveryRider) {
        this.deliveryRider = deliveryRider;
    }
}
