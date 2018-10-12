package com.solution;

import java.util.List;

public class ReportClientTotalQuantity extends Report{

    public long getQuantity() {
        return quantity;
    }

    private long quantity;

    Client client;

    public String toString(){
        return "Orders quantity for clientID = " + this.client.getClientId()+ "     :"+ this.quantity;
    }

    public ReportClientTotalQuantity(List<Order> list, Client client) {
        //int quantity=0;
        this.client=client;
         quantity = list.stream()
                .filter(order-> order.getClientId().equals(client.getClientId()))
                .count();
    }
}
