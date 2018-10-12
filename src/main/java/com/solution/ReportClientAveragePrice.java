package com.solution;

import java.util.List;

public class ReportClientAveragePrice extends Report {

    public double getClientAveragePrice() {
        return clientAveragePrice;
    }

    private double clientAveragePrice;
    Client client;

    public String toString() {
        return "Averege price for client: " + this.client.getClientId() + " = " + clientAveragePrice;
    }

    ReportClientAveragePrice(List<Order> list, Client client) {
        this.client = client;
        clientAveragePrice = list.stream()
                .filter(order -> order.getClientId().equals(client.getClientId()))
                .map(Order::getPrice)
                .reduce(Double.valueOf(0), (sum, order) -> sum + order);

        try {
            clientAveragePrice = clientAveragePrice / list.size();
        } catch (Exception ex) {
            System.out.println("Lista pusta, nie można dzielić przez 0");
        }

    }
}
