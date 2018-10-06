package com.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {

    public enum Column{Client_Id,Request_id, Name,Quantity,Price}
    public static List<Order> readFile() {

        List<Order> list= new ArrayList<>();


        String csvFile = "file.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            Map<Column,Integer> map = new HashMap<>();
            int counter=0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] order = line.split(cvsSplitBy);

               if(counter==0) {
                   for (int i = 0; i < 5; i++) {
                       map.put(Column.valueOf(order[i]), i);
                   }
               }

               if(counter>0) {
                   list.add(new Order(order[map.get(Column.Client_Id)], Integer.parseInt(order[map.get(Column.Request_id)]),
                           order[map.get(Column.Name)], Integer.parseInt(order[map.get(Column.Quantity)]),
                           BigDecimal.valueOf(Double.parseDouble(order[map.get(Column.Price)]))));
               }
                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
                counter++;
            }
            }

         catch (IOException e) {
            e.printStackTrace();
        }
        return list;


    }



}


