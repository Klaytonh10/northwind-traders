package com.pluralsight;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    private static String url = "jdbc:mysql://localhost:3306/northwind";
    private static String user = "root";
    private static String password = "yearup";

    public static ArrayList<Product> DBQuery() throws SQLException {

        ArrayList<Product> products = new ArrayList<>();

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM products";

        ResultSet resultSet = statement.executeQuery(query);

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("ProductID");
                String name = resultSet.getString("ProductName");
                double price = resultSet.getDouble("UnitPrice");
                int stock = resultSet.getInt("UnitsInStock");

                Product product = new Product(id, name, price, stock);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (connection != null) connection.close();
        }


        return products;
    }
}
