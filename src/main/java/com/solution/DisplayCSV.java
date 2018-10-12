package com.solution;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DisplayCSV {


    public static void createReport(Report report) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("Report.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append(report);
        pw.write(sb.toString());
        pw.close();
    }

}
