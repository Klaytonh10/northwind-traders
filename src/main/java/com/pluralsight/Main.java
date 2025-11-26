package com.pluralsight;

import com.mysql.cj.jdbc.exceptions.SQLError;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> products = null;

        try {
            products = DB.DBQuery();

            for (Product product : products) {
                System.out.println("ID: " + String.valueOf(product.getId()));
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + String.valueOf(product.getPrice()));
                System.out.println("Stock: " + String.valueOf(product.getUnitsInStock()));
                System.out.println("-----------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}