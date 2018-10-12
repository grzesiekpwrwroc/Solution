package com.solution;


import java.util.List;
import java.util.stream.Collectors;

public class ReportClientOrdersList extends Report {

    private List<Order> list1;

    private Client client;

    public String toString() {
        return "Orders list for Client: " + this.client.getClientId() + '\n' + this.printList(list1, client);
    }

    public String printList(List<Order> list, Client client) {
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            print.append(list.get(i).getRequestId() + " ");
            print.append(list.get(i).getName() + " ");
            print.append(list.get(i).getQuantity() + " ");
            print.append(list.get(i).getPrice() + " ");
            print.append(System.getProperty("line.separator"));
        }
        return String.valueOf(print);
    }

    public ReportClientOrdersList(List<Order> list, Client client) {
        this.client = client;
        list1 = list.stream()
                .filter(order -> order.getClientId().equals(client.getClientId()))
                .collect(Collectors.toList());
    }
}
