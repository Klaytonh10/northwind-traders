package com.pluralsight;

public class Product {

    private int id;
    private String name;
    private double price;
    private int unitsInStock;

    public Product(int id, String name, double price, int unitsInStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unitsInStock = unitsInStock;
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
