package com.solution;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {

    public enum Column {Client_Id, Request_id, Name, Quantity, Price}

    public static List<Order> readCSVFile(Base base, String csvFile) {

        List<Order> list = base.getBase();

        String line;
        String cvsSplitBy = ",";

        int clientId = 0;
        int requestId = 0;
        String name = "";
        int quantity = 0;
        double price = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            Map<Column, Integer> map = new HashMap<>();
            int counter = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] order = line.split(cvsSplitBy);

                if (counter == 0) {
                    for (int i = 0; i < 5; i++) {
                        map.put(Column.valueOf(order[i]), i);
                    }
                }

                if (counter > 0) {
                    try {
                        clientId = Integer.parseInt(order[map.get(Column.Client_Id)]);
                    } catch (RuntimeException ex) {
                        if (ex instanceof NullPointerException) {
                            System.out.println("Błąd w pliku CSV " + csvFile);
                            continue;
                        }
                        if (ex instanceof NumberFormatException) {
                            System.out.println("Nieprawidłowy format pola clientId " + csvFile);
                            continue;
                        }
                    }

                    try {
                        requestId = Integer.parseInt(order[map.get(Column.Request_id)]);
                    } catch (RuntimeException ex) {
                        if (ex instanceof NullPointerException) {
                            System.out.println("Błąd w pliku CSV " + csvFile);
                            continue;
                        }
                        if (ex instanceof NumberFormatException) {
                            System.out.println("Nieprawidłowy format pola requestId " + csvFile);
                            continue;
                        }
                    }

                    try {
                        name = order[map.get(Column.Name)];
                    } catch (RuntimeException ex) {
                        if (ex instanceof NullPointerException) {
                            System.out.println("Błąd w pliku CSV " + csvFile);
                            continue;
                        }
                    }

                    try {
                        quantity = Integer.parseInt(order[map.get(Column.Quantity)]);
                    } catch (RuntimeException ex) {
                        if (ex instanceof NullPointerException) {
                            System.out.println("Błąd w pliku CSV " + csvFile);
                            continue;
                        }
                        if (ex instanceof NumberFormatException) {
                            System.out.println("Nieprawidłowy format pola quantity " + csvFile);
                            continue;
                        }
                    }

                    try {
                        price = Double.parseDouble(order[map.get(Column.Price)]);
                    } catch (RuntimeException ex) {
                        if (ex instanceof NullPointerException) {
                            System.out.println("Błąd w pliku CSV");
                            continue;
                        }
                        if (ex instanceof NumberFormatException) {
                            System.out.println("Nieprawidłowy format pola price " + csvFile);
                            continue;
                        }
                    }
                    list.add(new Order(String.valueOf(clientId), requestId, name, quantity, price));
                }

                counter++;
            }
        } catch (IOException e) {
            System.out.println("Wczytywanie pliku nie powiodło się! " + csvFile);
        }
        return list;


    }

    public static List<Order> readXMLFile(Base base, String xmlFile) {

        List<Order> list = base.getBase();

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = docBuilder.parse(new File(String.valueOf(xmlFile)));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }


        doc.getDocumentElement().normalize();

        NodeList listOfOrders = doc.getElementsByTagName("request");
        int totalOrders = listOfOrders.getLength();

        String clientID = "";
        int requestID = 0;
        String name1;
        int quantity = 0;
        double price = 0;

        for (int s = 0; s < listOfOrders.getLength(); s++) {


            Node firstOrderNode = listOfOrders.item(s);
            if (firstOrderNode.getNodeType() == Node.ELEMENT_NODE) {


                Element firstRequestElement = (Element) firstOrderNode;


                try {
                    NodeList clientIdList = firstRequestElement.getElementsByTagName("clientId");
                    Element clientIdElement = (Element) clientIdList.item(0);

                    NodeList textClientIdList = clientIdElement.getChildNodes();
                    clientID = ((Node) textClientIdList.item(0)).getNodeValue().trim();
                } catch (RuntimeException ex) {
                    if (ex instanceof NullPointerException) {
                        System.out.println("Błąd w pliku XML! " + xmlFile + " Zignorowano rekord " + ex.getMessage());
                        continue;
                    }
                    if (ex instanceof NumberFormatException) {
                        System.out.println("Niepoprawny format pola clientId. Zignorowano rekord " + ex.getMessage() + " " + xmlFile);
                        continue;
                    }
                }

                try {
                    NodeList requestIdList = firstRequestElement.getElementsByTagName("requestId");
                    Element requestIdElement = (Element) requestIdList.item(0);

                    NodeList textRequestId = requestIdElement.getChildNodes();
                    requestID = Integer.parseInt(((Node) textRequestId.item(0)).getNodeValue().trim());
                } catch (RuntimeException ex) {
                    if (ex instanceof NullPointerException) {
                        System.out.println("Błąd w pliku XML! " + xmlFile + " Zignorowano rekord " + ex.getMessage());
                        continue;
                    }
                    if (ex instanceof NumberFormatException) {
                        System.out.println("Niepoprawny format pola requestId. Zignorowano rekord " + ex.getMessage() + " " + xmlFile);
                        continue;
                    }
                }

                try {
                    NodeList name = firstRequestElement.getElementsByTagName("name");
                    Element nameElement = (Element) name.item(0);

                    NodeList textNameList = nameElement.getChildNodes();
                    name1 = ((Node) textNameList.item(0)).getNodeValue().trim();
                } catch (NullPointerException e) {
                    System.out.println("Błąd w pliku XML! " + xmlFile + " Zignorowano rekord " + e.getMessage());
                    continue;
                }

                try {
                    NodeList quantityList = firstRequestElement.getElementsByTagName("quantity");
                    Element quantityElement = (Element) quantityList.item(0);

                    NodeList textQuantityList = quantityElement.getChildNodes();
                    quantity = Integer.parseInt(((Node) textQuantityList.item(0)).getNodeValue().trim());
                } catch (RuntimeException ex) {
                    if (ex instanceof NullPointerException) {
                        System.out.println("Błąd w pliku XML! " + xmlFile + " Zignorowano rekord " + ex.getMessage());
                        continue;
                    }
                    if (ex instanceof NumberFormatException) {
                        System.out.println("Niepoprawny format pola quantity. Zignorowano rekord " + ex.getMessage() + " " + xmlFile);
                        continue;
                    }

                }
                try {
                    NodeList priceList = firstRequestElement.getElementsByTagName("price");
                    Element priceElement = (Element) priceList.item(0);

                    NodeList textPriceList = priceElement.getChildNodes();
                    price = Double.parseDouble(((Node) textPriceList.item(0)).getNodeValue().trim());
                } catch (RuntimeException ex) {
                    if (ex instanceof NullPointerException) {
                        System.out.println("Błąd w pliku XML! " + xmlFile + " Zignorowano rekord " + ex.getMessage());
                        continue;
                    }
                    if (ex instanceof NumberFormatException) {
                        System.out.println("Niepoprawny format pola price. Zignorowano rekord " + ex.getMessage() + " " + xmlFile);
                        continue;
                    }
                }

                list.add(new Order(clientID, requestID, name1, quantity, price));

            }


        }

        return base.getBase();
    }

}


