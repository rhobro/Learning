/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpaceChallenge
 * File Name: Item.java
 * Last Modified: 08/05/19 20:34
 */

package com.RoBroTech.Dev.SpaceChallenge;

import org.jetbrains.annotations.Contract;

public class Item {

    // Member fields
    // The name of the item
    private String name;
    // The weight of the item (KG).
    private int weight;

    // Default constructor
    @Contract(pure = true)
    public Item(String itemName, int weightOfItem) {
        this.name = itemName;
        this.weight = weightOfItem;
    }

    // Getters
    // Item Name
    public String getName() {
        return name;
    }
    // Item Weight
    public int getWeight() {
        return weight;
    }
}
