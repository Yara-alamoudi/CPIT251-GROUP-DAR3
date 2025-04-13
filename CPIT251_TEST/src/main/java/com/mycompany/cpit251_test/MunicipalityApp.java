package com.mycompany.cpit251_test;

import java.io.*;
import java.util.*;

public class MunicipalityApp {
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("neighborhoods.txt");

        System.out.println("Welcome to Jeddah Municipality Complaint System");
        System.out.print("Are you an Applicant or Employee? (a/e): ");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("a")) {
            Applicate applicant = new Applicate(scanner, fileHandler);
//            applicant.registerAndSubmitForm();
        } else if (role.equalsIgnoreCase("e")) {
//            Employee employee = new Employee(scanner);
            
        } else {
            System.out.println("Invalid role selected.");
        }
    }
}

