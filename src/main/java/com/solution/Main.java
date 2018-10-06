package com.solution;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Order> list= new ArrayList<>();
//       /List<Order> orders= proccessFiles(list);
//
        //ReportTotalQuantity totalQuantity= new ReportTotalQuantity(orders.size());
        //totalQuantity.setQorders.size());
//        Client client= new Client(2);
        // ReportClientTotalQuantity clientTotalQuanuantiy(tity = new ReportClientTotalQuantity(client);
        list=ReadFile.readFile();
        System.out.println(new ReportTotalOrdersPrice(list));
        System.out.println(new ReportClientTotalOrdersPrice(list,new Client("1")));
    }
}
