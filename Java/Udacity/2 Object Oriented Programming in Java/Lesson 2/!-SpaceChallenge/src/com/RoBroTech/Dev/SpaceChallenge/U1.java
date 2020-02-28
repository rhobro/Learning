/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpaceChallenge
 * File Name: U1.java
 * Last Modified: 08/05/19 20:34
 */

package com.RoBroTech.Dev.SpaceChallenge;

public class U1 extends Rocket {

    // Member fields described in the Rocket class.

    // Default constructor
    public U1() {
        this.setCost(100000000);
        this.setWeight(10000);
        this.setMaxWeight(18000);
        this.setMaxCargoWeight(this.getMaxWeight() - this.getWeight());
        this.getCargoItems().clear();
        this.setCargoWeight(0);
    }

    // Overriding launch method described in the Rocket class and SpaceShip interface.
    @Override
    public boolean launch() {

        // Setting launch crash probability
        this.setChanceLaunchCrash(0.05 * (this.getCargoWeight() / this.getMaxCargoWeight()));

        // Returning if the launch crash probability is met
        return Math.random() > this.getChanceLaunchCrash();
    }

    // Overriding launch method described in the Rocket class and SpaceShip interface.
    @Override
    public boolean land() {

        // Setting landing crash probability
        this.setChanceLandingCrash(0.01 * (this.getCargoWeight() / this.getMaxCargoWeight()));

        // Returning if the landing crash probability is met.
        return Math.random() > this.getChanceLandingCrash();
    }
}
