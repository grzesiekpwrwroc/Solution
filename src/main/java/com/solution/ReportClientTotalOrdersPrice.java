package com.solution;

import java.util.List;


public class ReportClientTotalOrdersPrice extends Report{

    public double getClientTotalPrice() {
        return clientTotalPrice;
    }

    private double clientTotalPrice;
    String clientId;

    public String toString(){
        return "Total order price for client ID = " + clientId+ ": "+String.valueOf(this.clientTotalPrice);
    }
    ReportClientTotalOrdersPrice(List<Order> list, Client client) {
        clientId= String.valueOf(client.getClientId());
        clientTotalPrice = list.stream()
                .filter(order-> order.getClientId().equals(client.getClientId()))
                .map(Order::getPrice)
                .reduce(Double.valueOf(0), (sum, order) -> sum+order);
    }
}

