package com.solution;

import java.math.BigDecimal;
import java.util.List;


public class ReportClientTotalOrdersPrice {

    BigDecimal totalPrice;
    String clientId;

    public String toString(){
        return "Total order price for client: " + clientId+ " "+String.valueOf(this.totalPrice);
    }
    ReportClientTotalOrdersPrice(List<Order> list, Client client) {
        clientId= String.valueOf(client.getClientId());
        totalPrice = list.stream()
                .filter(order-> order.getClientId().equals(client.getClientId()))
                .map(Order::getPrice)

                .reduce(BigDecimal.valueOf(0), (sum, order) -> sum.add(order));
    }
}

