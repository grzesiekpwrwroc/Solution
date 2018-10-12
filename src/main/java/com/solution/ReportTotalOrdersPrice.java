package com.solution;

import java.math.BigDecimal;
import java.util.List;

public class ReportTotalOrdersPrice extends Report {

    public String toString() {
        return "Total Order Price: " + String.valueOf(this.totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double totalPrice;

    public ReportTotalOrdersPrice(List<Order> list) {
        totalPrice = list.stream()
                .map(Order::getPrice)
                .reduce(Double.valueOf(0), (sum, order) -> sum + order);
    }
}
