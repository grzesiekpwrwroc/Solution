package com.solution;

import java.math.BigDecimal;
import java.util.List;

public class ReportTotalOrdersPrice {

    public String toString(){
        return "Total Order Price: " + String.valueOf(this.totalPrice);
    }

    BigDecimal totalPrice;
    public ReportTotalOrdersPrice(List<Order> list) {
        //int quantity=0;
         totalPrice = list.stream()
                .map(Order::getPrice)
                .reduce(BigDecimal.valueOf(0), (sum, order) -> sum.add( order));
    }
}
