package com.pluralsight;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Product> products = null;
    public static ArrayList<Customer> customers = null;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while(running){
            System.out.println("""
                    =========================
                     What do you want to do?
                    =========================
                    
                    1) Display all products
                    2) Display all customers
                    3) Exit
                    
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    handleProductsQuery();
                    break;
                case "2":
                    handleCustomerQuery();
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("\nPlease make a valid selection\n");
            }
        }

    }

    public static void handleCustomerQuery() {
        try {
            customers = DB.customerQuery();

            for (Customer customer : customers) {
                System.out.println("ID: " + String.valueOf(customer.getId()));
                System.out.println("Contact Name: " + customer.getContactName());
                System.out.println("Company: " + customer.getCompany());
                System.out.println("City: " + customer.getCity());
                System.out.println("Country: " + customer.getCountry());
                System.out.println("Phone Number: " + customer.getPhoneNumber());
                System.out.println("-----------\n\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void handleProductsQuery() {
        try {
            products = DB.productsQuery();

            for (Product product : products) {
                System.out.println("ID: " + String.valueOf(product.getId()));
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + String.valueOf(product.getPrice()));
                System.out.println("Stock: " + String.valueOf(product.getUnitsInStock()));
                System.out.println("-----------\n\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}