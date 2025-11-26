package com.pluralsight;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                "root",
                "yearup");

        Statement statement = connection.createStatement();

        String query = "SELECT * FROM products";

        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()) {
            String outString = resultSet.getString("ProductName");
            System.out.println(outString);
        }

        connection.close();
    }
}