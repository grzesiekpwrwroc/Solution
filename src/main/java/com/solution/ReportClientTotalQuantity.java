package com.solution;

import java.util.List;

public class ReportClientTotalQuantity {

    private long quantity;

    public ReportClientTotalQuantity(List<Order> list, Client client) {
        //int quantity=0;
         quantity = list.stream()
                .filter(order-> order.getClientId() == client.getClientId())
                .count();
    }
}
