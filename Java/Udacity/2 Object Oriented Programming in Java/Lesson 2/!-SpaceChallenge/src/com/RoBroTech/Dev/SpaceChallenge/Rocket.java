/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpaceChallenge
 * File Name: Rocket.java
 * Last Modified: 08/05/19 20:34
 */

package com.RoBroTech.Dev.SpaceChallenge;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Rocket implements SpaceShip {

    // Member fields
    // Cost of the rocket. ($)
    private long cost;
    // Weight of the rocket when it is empty. (KG)
    private double weight;
    // Maximum weight of rocket with cargo. (KG)
    private double maxWeight;
    // Weight of cargo being carried. (KG)
    private double cargoWeight;
    // Maximum weight of cargo. (KG)
    private double maxCargoWeight;
    // ArrayList of cargo items;
    private ArrayList<Item> cargoItems = new ArrayList<>();
    // Chance of crashing at launch
    private double chanceLaunchCrash;
    // Chance of crash at landing
    private double chanceLandingCrash;

    // The boolean launch method described in the SpaceShip interface. (GOING TO BE OVERRIDDEN in U1 and U2)
    @Override
    public boolean launch() {
        return false;
    }

    // The boolean landing method described in the SpaceShip interface. (GOING TO BE OVERRIDDEN in U1 and U2)
    @Override
    public boolean land() {
        return false;
    }

    // The boolean method to check if an item can be carried described in the SpaceShip interface.
    public boolean canCarry(@NotNull Item itemToCarry) {
        if((this.weight + this.cargoWeight + itemToCarry.getWeight()) <= this.maxWeight) {
            return true;
        } else {
            return false;
        }
    }

    // The method to carry an item described in the SpaceShip interface.
    public void carry(Item itemToCarry) {
        if(canCarry(itemToCarry)) {
            this.cargoItems.add(itemToCarry);
            this.cargoWeight += itemToCarry.getWeight();
        }
    }

    // Getters and setters

    // Rocket cost
    public long getCost() {
        return cost;
    }
    protected void setCost(long cost) {
        this.cost = cost;
    }

    // Rocket weight
    public double getWeight() {
        return weight;
    }
    protected void setWeight(double weight) {
        this.weight = weight;
    }

    // Rocket maxWeight
    protected double getMaxWeight() {
        return maxWeight;
    }
    protected void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    // Rocket cargoWeight
    public double getCargoWeight() {
        return cargoWeight;
    }
    protected void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    // Rocket maxCargoWeight
    public double getMaxCargoWeight() {
        return maxCargoWeight;
    }
    protected void setMaxCargoWeight(double maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    // Rocket cargoItems
    public ArrayList<Item> getCargoItems() {
        return cargoItems;
    }

    // Rocket chanceLaunchCrash
    public double getChanceLaunchCrash() {
        return chanceLaunchCrash;
    }
    protected void setChanceLaunchCrash(double chanceLaunchCrash) {
        this.chanceLaunchCrash = chanceLaunchCrash;
    }

    // Rocket chanceLandingCrash
    public double getChanceLandingCrash() {
        return chanceLandingCrash;
    }
    protected void setChanceLandingCrash(double chanceLandingCrash) {
        this.chanceLandingCrash = chanceLandingCrash;
    }
}
