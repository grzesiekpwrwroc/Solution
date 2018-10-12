package com.solution;

import java.math.BigDecimal;

public class Order {

    public String getClientId() {
        return clientId;
    }

    private String clientId;

    public int getRequestId() {
        return requestId;
    }

    private int requestId;
    private String name;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    private int quantity;

    public double getPrice() {
        return price;
    }

    private double price;

    public Order(String clientId, int requestId, String name, int quantity, double price) {
        this.clientId = clientId;
        this.requestId = requestId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
