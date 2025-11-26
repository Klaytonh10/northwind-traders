package com.pluralsight;

import java.util.ArrayList;

public class Category {

    private ArrayList<Product> products;

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
