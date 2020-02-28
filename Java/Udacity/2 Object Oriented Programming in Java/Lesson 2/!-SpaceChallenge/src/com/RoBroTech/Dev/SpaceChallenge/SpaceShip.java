/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpaceChallenge
 * File Name: SpaceShip.java
 * Last Modified: 08/05/19 20:34
 */

package com.RoBroTech.Dev.SpaceChallenge;

public interface SpaceShip {

    // Method definitions
    // A boolean return-type method which returns 'true' for a successful launch or 'false' for a launch crash.
    boolean launch();
    // A boolean return-type method which returns 'true' for a successful landing or 'false' for a landing crash.
    boolean land();
    // A boolean method which returns if the rocket can carry the arg item.
    boolean canCarry(Item itemToCarry);
    // A method to carry the item if it has been verified as canCarry(Item itemToCarry) = true. Updates the weight of the rocket.
    void carry(Item itemToCarry);
}
