package com.solution;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        Base base = new Base();

        for (int i = 0; i < args.length; i++) {


            if (args[i].charAt(args[i].length() - 1) == 'v') {
                base.setBase(ReadFile.readCSVFile(base, args[i]));
            }

            if (args[i].charAt(args[i].length() - 1) == 'l') {
                base.setBase(ReadFile.readXMLFile(base, args[i]));
            }
        }
        if(base.getBase().size()==0) {
            System.out.println("Nie udało się wczytać plików");
        }
        else {
            while (true) {
                System.out.println("To generate Total quantity report press 1 ");
                System.out.println("To generate Total orders price report press 2 ");
                System.out.println("To generate Total orders list report press 3");
                System.out.println("To generate quantity for client press 4");
                System.out.println("To generate orders price for client press 5 ");
                System.out.println("To generate client orders list report press 6 ");
                System.out.println("To generate average price for client press 7 ");
                System.out.println("To generate average price press 8 ");

                Scanner scanner = new Scanner(System.in);

                String choice2 = scanner.next();
                if (Pattern.matches("\\d+", choice2)) {
                    int choice = Integer.parseInt(choice2);
                    switch (choice) {
                        case 1:
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            int reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportTotalQuantity(base.getBase()));
                            }
                            if (reportChoice == 2) {
                                DisplayCSV.createReport(new ReportTotalQuantity(base.getBase()));
                            }
                            break;
                        case 2:
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportTotalOrdersPrice(base.getBase()));
                            }
                            if (reportChoice == 2) {
                                DisplayCSV.createReport(new ReportTotalOrdersPrice(base.getBase()));
                            }
                            break;
                        case 3:
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportOrdersList(base.getBase()));
                            }
                            if (reportChoice == 2) {
                                ReportOrdersList report = new ReportOrdersList(base.getBase());
                                DisplayCSV.createReport(report);
                            }


                            break;
                        case 4:
                            System.out.println("Plese enter the clientID ");
                            int id = scanner.nextInt();
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportClientTotalQuantity(base.getBase(), new Client(String.valueOf(id))));
                            }
                            if (reportChoice == 2) {
                                DisplayCSV.createReport(new ReportClientTotalQuantity(base.getBase(), new Client(String.valueOf(id))));
                            }
                            break;

                        case 5:
                            System.out.println("Plese enter the clientID ");
                            id = scanner.nextInt();
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportClientTotalOrdersPrice(base.getBase(), new Client(String.valueOf(id))));
                            }
                            if (reportChoice == 2) {
                                DisplayCSV.createReport(new ReportClientTotalOrdersPrice(base.getBase(), new Client(String.valueOf(id))));
                            }
                            break;

                        case 6:
                            System.out.println("Plese enter the clientID ");
                            id = scanner.nextInt();
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportClientOrdersList(base.getBase(), new Client(String.valueOf(id))));
                            }
                            if (reportChoice == 2) {
                                DisplayCSV.createReport(new ReportClientOrdersList(base.getBase(), new Client(String.valueOf(id))));
                            }
                            break;

                        case 7:
                            System.out.println("Plese enter the clientID ");
                            id = scanner.nextInt();
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportClientAveragePrice(base.getBase(), new Client(String.valueOf(id))));
                            }
                            if (reportChoice == 2) {
                                DisplayCSV.createReport(new ReportClientAveragePrice(base.getBase(), new Client(String.valueOf(id))));
                            }
                            break;

                        case 8:
                            System.out.println("Report on the screen = 1, report to CSV file= 2");
                            reportChoice = scanner.nextInt();
                            if (reportChoice == 1) {
                                DisplayScreen.createReport(new ReportAveragePrice(base.getBase()));
                            }
                            if (reportChoice == 2) {
                                DisplayCSV.createReport(new ReportAveragePrice(base.getBase()));
                            }
                            break;
                        default:
                            System.out.println("Zły format wejścia! Proszę podać cyfrę z przedziału <1,8>");

                    }
                } else {
                    System.out.println("Zły format wejścia! Proszę podać cyfrę z przedziału <1,8>");
                }
            }

        }
    }
}
