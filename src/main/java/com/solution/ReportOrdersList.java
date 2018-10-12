package com.solution;

import java.util.List;

public class ReportOrdersList extends Report {

    private List<Order> list;

    public String printList(List<Order> list){
        StringBuilder print = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            print.append(list.get(i).getClientId()+ " ");
            print.append(list.get(i).getRequestId()+ " ");
            print.append(list.get(i).getName()+ " ");
            print.append(list.get(i).getQuantity()+ " ");
            print.append(list.get(i).getPrice()+ " ");
            print.append('\n');
        }
        return String.valueOf(print);
    }

    public String toString(){
        return "Report orders list: " + '\n' + this.printList(list);
    }

    public ReportOrdersList(List<Order> list) {
        this.list=list;
    }

}
