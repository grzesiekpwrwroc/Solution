package com.solution;

import java.math.BigDecimal;

public class Order {

    public String getClientId() {
        return clientId;
    }

    private String clientId;
    private int requestId;
    private String name;
    private int quantity;

    public BigDecimal getPrice() {
        return price;
    }

    private BigDecimal price;

    public Order(String clientId, int requestId, String name, int quantity, BigDecimal price) {
        this.clientId = clientId;
        this.requestId = requestId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
