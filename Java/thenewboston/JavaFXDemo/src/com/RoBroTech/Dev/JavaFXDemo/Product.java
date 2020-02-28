/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: JavaFXDemo
 * File Name: Product.java
 * Last Modified: 05/08/19 16:26
 */

package com.RoBroTech.Dev.JavaFXDemo;

import org.jetbrains.annotations.Contract;

public class Product {

    // Member fields
    // Product name
    private String name;
    // Product price
    private double price;
    // Product quantity
    private int quantity;

    @Contract(pure = true)
    public Product() {
        this.name = "";
        this.price = 0;
        this.quantity = 0;
    }

    @Contract(pure = true)
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
