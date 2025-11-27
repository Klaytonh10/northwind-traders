package com.pluralsight;

public class Product {

    private int id;
    private String name;
    private double price;
    private int unitsInStock;
    private int categoryID;

    public Product(int id, String name, double price, int unitsInStock, int categoryID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.categoryID = categoryID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }
}
