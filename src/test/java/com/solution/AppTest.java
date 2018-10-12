package com.solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AppTest {

    @Test
    public void totalQuantity_returns4() {
        Base base = new Base();
        //ReadFile rd = new ReadFile();
        List<Order> list = new ArrayList<>();
        list.add(new Order("1", 1, "Bułka", 1, 10));
        list.add(new Order("1", 1, "Chleb", 2, 15));
        list.add(new Order("1", 2, "Chleb", 5, 15));
        list.add(new Order("2", 1, "Chleb", 1, 10));
        base.setBase(list);
        int result = new ReportTotalQuantity(base.getBase()).getQuantity();
        assertEquals(4, result);
    }

    @Test
    public void averagePrice_returns20() {

        Base base = new Base();

        List<Order> list = new ArrayList<>();
        list.add(new Order("1", 1, "Bułka", 1, 30));
        list.add(new Order("1", 1, "Chleb", 2, 15));
        list.add(new Order("1", 2, "Chleb", 5, 15));
        list.add(new Order("2", 1, "Chleb", 1, 20));
        base.setBase(list);
        double result = new ReportAveragePrice(base.getBase()).getAveragePrice();
        assertEquals(20, (int) result);
    }

    @Test
    public void clientAveragePrice_returns15() {

        Base base = new Base();

        List<Order> list = new ArrayList<>();
        list.add(new Order("1", 1, "Bułka", 1, 30));
        list.add(new Order("1", 1, "Chleb", 2, 15));
        list.add(new Order("1", 2, "Chleb", 5, 15));
        list.add(new Order("2", 1, "Chleb", 1, 20));
        base.setBase(list);
        double result = new ReportClientAveragePrice(base.getBase(), new Client("1")).getClientAveragePrice();
        assertEquals(15, (int) result);
    }

    @Test
    public void clientTotalQuantity_returns3() {

        Base base = new Base();

        List<Order> list = new ArrayList<>();
        list.add(new Order("1", 1, "Bułka", 1, 30));
        list.add(new Order("1", 1, "Chleb", 2, 15));
        list.add(new Order("1", 2, "Chleb", 5, 15));
        list.add(new Order("2", 1, "Chleb", 1, 20));
        base.setBase(list);
        long result = new ReportClientTotalQuantity(base.getBase(), new Client("1")).getQuantity();
        assertEquals(3, (int) result);
    }

    @Test
    public void totalOrdersPrice_returns80() {

        Base base = new Base();

        List<Order> list = new ArrayList<>();
        list.add(new Order("1", 1, "Bułka", 1, 30));
        list.add(new Order("1", 1, "Chleb", 2, 15));
        list.add(new Order("1", 2, "Chleb", 5, 15));
        list.add(new Order("2", 1, "Chleb", 1, 20));
        base.setBase(list);
        double result = new ReportTotalOrdersPrice(base.getBase()).getTotalPrice();
        assertEquals(80, (int) result);
    }

    @Test
    public void clientTotalOrdersPrice_returns60() {

        Base base = new Base();

        List<Order> list = new ArrayList<>();
        list.add(new Order("1", 1, "Bułka", 1, 30));
        list.add(new Order("1", 1, "Chleb", 2, 15));
        list.add(new Order("1", 2, "Chleb", 5, 15));
        list.add(new Order("2", 1, "Chleb", 1, 20));
        base.setBase(list);
        double result = new ReportClientTotalOrdersPrice(base.getBase(), new Client("1")).getClientTotalPrice();
        assertEquals(60, (int) result);
    }
}
