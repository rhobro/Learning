/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpaceChallenge
 * File Name: Simulation.java
 * Last Modified: 08/05/19 20:34
 */

package com.RoBroTech.Dev.SpaceChallenge;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // Method to load items from chosen phase into an ArrayList and return it.
    public ArrayList<Item> loadItems(@NotNull String phase) throws Exception {

        // Preparation
        // The ArrayList of Items which will be returned
        ArrayList<Item> phaseList = new ArrayList<>();
        // A temporary ArrayList to add each line from the phase list.
        ArrayList<String> tmpList = new ArrayList<>();
        // The file which will be the phase list file.
        File phaseFile;
        // A temporary store of the name of the item in a char array.
        char[] itemName;
        // The number of letters in the temporary name.
        int itemNameNumOfLetters;
        // The weight of the temporary item
        char[] itemWeight;
        // Number of digits in the item's weight
        int itemWeightNumOfDigits;
        // A temporary boolean to tell if the equal sign has been passed.
        boolean equalsSignPassed;

        // Switching the path to the file depending on which phase is specified.
        switch(phase) {
            case "phase-1": default:
                phaseFile = new File("src/com/RoBroTech/Dev/SpaceChallenge/phase-1.txt");
                break;

            case "phase-2":
                phaseFile = new File("src/com/RoBroTech/Dev/SpaceChallenge/phase-2.txt");
                break;
        }
        // Scanner to read the phaseFile.
        Scanner phaseFileScanner = new Scanner(phaseFile);
        // Adding each line of the phaseFile to the temporary ArrayList.
        while(phaseFileScanner.hasNextLine()) {
            tmpList.add(phaseFileScanner.nextLine());
            if(!phaseFileScanner.hasNextLine()) {
                break;
            }
        }
        // Loop to split each line in tmpList to be able to create Item objects.
        for(String item : tmpList) {
            itemNameNumOfLetters = 0;
            itemWeightNumOfDigits = 0;
            equalsSignPassed = false;
            // Counting the number of letters in the name of the item.
            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) != '=' && !equalsSignPassed) {
                    itemNameNumOfLetters++;
                } else if (item.charAt(i) == '=') {
                    equalsSignPassed = true;
                } else if (equalsSignPassed) {
                    itemWeightNumOfDigits++;
                }
            }
            // Creating the char array for the item name based on the number of letters.
            itemName = new char[itemNameNumOfLetters];
            // Creating the char array for the item weight based on the number of digits.
            itemWeight = new char[itemWeightNumOfDigits];
            // Adding the item name and weight to the char arrays.
            for (int i = 0; i < item.length(); i++) {
                if (i < itemNameNumOfLetters) {
                    itemName[i] = item.charAt(i);
                } else if (i > itemNameNumOfLetters && i + itemWeightNumOfDigits >= item.length()) {
                    itemWeight[i - itemNameNumOfLetters - 1] = item.charAt(i);
                }
            }
            // Use the char arrays to create the String name and int weight.
            String stringItemName = new String(itemName);
            int intItemWeight = Integer.parseInt(new String(itemWeight));
            // Generate the item from the name and weight.
            Item itemToAdd = new Item(stringItemName, intItemWeight);
            // Add the item into the ArrayList.
            phaseList.add(itemToAdd);
        }

        // Returning the list of items
        return phaseList;
    }

    // The method to load U1 rockets
    public ArrayList<U1> loadU1(@NotNull ArrayList<Item> phaseItems) {

        // Preparation
        // A temporary ArrayList of Rockets
        ArrayList<U1> tmpFleetU1 = new ArrayList<>();
        // Count for the number of rockets.
        int rocketCount = 0;
        // Boolean to state if the item has been loaded
        boolean itemLoaded;
        // Boolean to state if a new rocket is needed for the item.
        boolean newRocketNeeded;

        // Adding the first rocket to the tmpFleetU1 ArrayList
        tmpFleetU1.add(new U1());
        // Adding the items to the rockets using foreach
        for(Item item : phaseItems) {
            itemLoaded = false;
            newRocketNeeded = false;
            while(!itemLoaded) {
                // Checking if the item can fit into one of the previously made rockets
                for(U1 rocketU1: tmpFleetU1) {
                    if(rocketU1.canCarry(item)) {
                        // Carrying item
                        rocketU1.carry(item);
                        itemLoaded = true;
                        newRocketNeeded = false;
                        break;
                    } else {
                        newRocketNeeded = true;
                    }
                }
                if(newRocketNeeded) {
                    // Adding new rocket if item cannot be carried.
                    tmpFleetU1.add(new U1());
                    rocketCount++;
                    if(tmpFleetU1.get(rocketCount).canCarry(item)) {
                        tmpFleetU1.get(rocketCount).carry(item);
                        itemLoaded = true;
                    }
                }
            }
        }

        // Returning the fleet of rockets with equipment loaded.
        return tmpFleetU1;
    }

    // The method to load U2 rockets
    public ArrayList<U2> loadU2(@NotNull ArrayList<Item> phaseItems) {

        // Preparation
        // A temporary ArrayList of Rockets
        ArrayList<U2> tmpFleetU2 = new ArrayList<>();
        // Count for the number of rockets.
        int rocketCount = 0;
        // Boolean to state if the item has been loaded
        boolean loaded;

        // Adding the first rocket to the tmpFleetU1 ArrayList
        tmpFleetU2.add(new U2());
        // Adding the items to the rockets using foreach
        for(Item item : phaseItems) {
            loaded = false;
            while(!loaded) {
                if(tmpFleetU2.get(rocketCount).canCarry(item)) {
                    // Carrying item
                    tmpFleetU2.get(rocketCount).carry(item);
                    loaded = true;
                } else {
                    // Adding new rocket if item cannot be carried.
                    tmpFleetU2.add(new U2());
                    rocketCount++;
                }
            }
        }

        // Returning the fleet of rockets with equipment loaded.
        return tmpFleetU2;
    }

    // The method to run the simulation
    public long runSimulation(@NotNull ArrayList<Rocket> rocketFleet) {

        // Preparation
        // Total budget in millions of dollars
        long budget;
        // Number of rockets used
        int rocketNum = 0;
        // A temporary boolean to show if a rocket was successful in taking off and landing
        boolean successful;

        // Loop calling the launch and land method of each rocket in rocketFleet ArrayList
        for(Rocket rocket : rocketFleet) {
            successful = false;

            // Looping until successful launch and landing
            while(!successful) {
                if(rocket.launch() && rocket.land()) {
                    successful = true;
                    rocketNum++;
                } else {
                    rocketNum++;
                }
            }
        }
        // Calculating the budget based on the number of rockets used
        budget = rocketFleet.get(0).getCost() * rocketNum / 1000000;

        // Returning the total budget
        return budget;
    }
}
