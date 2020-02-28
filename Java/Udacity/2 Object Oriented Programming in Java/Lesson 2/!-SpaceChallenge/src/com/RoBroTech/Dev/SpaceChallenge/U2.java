/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpaceChallenge
 * File Name: U2.java
 * Last Modified: 08/05/19 20:34
 */

package com.RoBroTech.Dev.SpaceChallenge;

public class U2 extends Rocket {

    // Member fields described in the Rocket class.

    // Default constructor
    public U2() {
        this.setCost(120000000);
        this.setWeight(18000);
        this.setMaxWeight(29000);
        this.setMaxCargoWeight(this.getMaxWeight() - this.getWeight());
        this.getCargoItems().clear();
        this.setCargoWeight(0);
    }

    // Overriding launch method described in the Rocket class and SpaceShip interface.
    @Override
    public boolean launch() {

        // Setting launch crash probability
        this.setChanceLaunchCrash(0.04 * (this.getCargoWeight() / this.getMaxCargoWeight()));

        // Returning if the landing crash probability is met
        return Math.random() > this.getChanceLaunchCrash();
    }

    // Overriding launch method described in the Rocket class and SpaceShip interface.
    public boolean land() {

        // Setting landing crash probability
        this.setChanceLandingCrash(0.08 * (this.getCargoWeight() / this.getMaxCargoWeight()));

        // Returning if the landing crash probability is met
        return Math.random() > this.getChanceLandingCrash();
    }
}
