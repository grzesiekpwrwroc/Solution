package com.solution;


import java.util.List;

public class ReportAveragePrice extends Report {

    public double getAveragePrice() {
        return averagePrice;
    }

    private double averagePrice = 0;

    public String toString() {
        return "Average order price = " + String.valueOf(this.averagePrice);
    }

    ReportAveragePrice(List<Order> list) {


        for (int i = 0; i < list.size(); i++) {
            averagePrice += list.get(i).getPrice();
        }
        try {
            averagePrice = averagePrice / list.size();
        } catch (Exception ex) {
            System.out.println("Lista pusta, nie można dzielić przez 0");
        }

    }
}
