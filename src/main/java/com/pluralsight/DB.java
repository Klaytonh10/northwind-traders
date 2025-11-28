package com.pluralsight;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    public static ArrayList<Product> productsQuery(MysqlDataSource dataSource) throws SQLException {

        ArrayList<Product> products = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
        ) {
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ProductID");
                    String name = resultSet.getString("ProductName");
                    double price = resultSet.getDouble("UnitPrice");
                    int stock = resultSet.getInt("UnitsInStock");
                    int categoryID = resultSet.getInt("CategoryID");

                    Product product = new Product(id, name, price, stock, categoryID);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static ArrayList<Customer> customerQuery(MysqlDataSource dataSource) throws SQLException {

        ArrayList<Customer> customers = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers ORDER BY country");
        ) {
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                while (resultSet.next()) {
                    String id = resultSet.getString("CustomerID");
                    String contactName = resultSet.getString("ContactName");
                    String companyName = resultSet.getString("CompanyName");
                    String city = resultSet.getString("City");
                    String country = resultSet.getString("Country");
                    String phoneNumber = resultSet.getString("Phone");

                    Customer customer = new Customer(id, contactName, companyName, city, country, phoneNumber);
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public static ArrayList<Category> categoryQuery(MysqlDataSource dataSource) throws SQLException {

        ArrayList<Category> categories = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT CategoryID, CategoryName FROM categories ORDER BY CategoryID");
        ) {
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()
            ) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("CategoryID");
                    String contactName = resultSet.getString("CategoryName");

                    Category category = new Category(id, contactName);
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

}
