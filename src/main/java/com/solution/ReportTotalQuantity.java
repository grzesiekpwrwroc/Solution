package com.solution;

import java.util.List;

public class ReportTotalQuantity extends Report {

    public int getQuantity() {
        return quantity;
    }

    private int quantity;

    public String toString() {
        return "Quantity of all orders = " + this.quantity;
    }

    public ReportTotalQuantity(List<Order> list) {
        quantity = list.size();
    }


}
