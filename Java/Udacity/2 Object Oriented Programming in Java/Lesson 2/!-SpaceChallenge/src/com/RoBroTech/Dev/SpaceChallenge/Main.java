/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpaceChallenge
 * File Name: Main.java
 * Last Modified: 11/05/19 08:58
 */

package com.RoBroTech.Dev.SpaceChallenge;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    // main method
    public static void main(String[] args) throws Exception {

        // Preparation
        // Scanner to read user input
        Scanner userInput = new Scanner(System.in);
        // The option which the user chooses. (MANUAL or AI)
        char startingOption;
        // A char for the user answering yes or no. (Y or N)
        char yesNo;
        // A String for the choice of rocket in a particular phase.
        String rocketToUse;
        // The budget required
        double budget;
        // Boolean to show if the user has actually chosen option 1 or 2 yet
        boolean doneAnythingYet = false;

        // Starting banner
        System.out.println("STARTING SPACE SIMULATOR...");
        // 2 second delay
        TimeUnit.SECONDS.sleep(2);
        // Introduction
        System.out.println("Welcome to the SpaceChallenge Simulator");
        // 1 second delay
        TimeUnit.SECONDS.sleep(1);
        // Loop until user uses either option 1 or 2
        while(!doneAnythingYet) {
            System.out.println("\nThere are two options for this software.");
            // 500 millisecond delay
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\n1 - Manually enter the parameters specifying the rockets to use");
            System.out.println("    in the different phases. You can select one or both phases to");
            System.out.println("    simulate as well as the type of rocket you would like to use");
            System.out.println("    individually.");
            // 500 millisecond delay
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\nOR");
            // 500 millisecond delay
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\n2 - Let the software run simulations using both rockets for both");
            System.out.println("    phases and advise which rocket would be optimum for each phase.");
            // 500 millisecond delay
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\nOR");
            // 500 millisecond delay
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\n3 - Learn more about how this software works and its options.");
            // 2 second delay
            TimeUnit.SECONDS.sleep(2);
            // Choose option
            System.out.print("\nPlease choose your option (1/2/3): ");
            startingOption = userInput.next().charAt(0);
            while (startingOption != '1' && startingOption != '2' && startingOption != '3') {
                System.out.print("Please enter a valid option: ");
                startingOption = userInput.next().charAt(0);
            }

            // Switch depending on the user response
            switch(startingOption) {
                case '1':
                    // Manual parameter entry

                    // Preparation
                    // 'Y' or 'N' for whether Phase 1 will be simulated.
                    char simPhase1;
                    // 'Y' or 'N' for whether Phase 2 will be simulated.
                    char simPhase2;
                    // Setting doneAnythingYet to true since user has chosen an active option
                    doneAnythingYet = true;

                    // Whether to simulate Phase 1
                    System.out.print("\nWould you like to simulate Phase-1? (Y or N): ");
                    yesNo = userInput.next().charAt(0);
                    while (yesNo != 'Y' && yesNo != 'y' && yesNo != 'N' && yesNo != 'n') {
                        System.out.print("Please enter a valid choice: ");
                        yesNo = userInput.next().charAt(0);
                    }
                    if(yesNo == 'Y' || yesNo == 'y') {
                        simPhase1 = 'Y';
                    } else {
                        simPhase1 = 'N';
                    }
                    // Whether to simulate Phase 2
                    System.out.print("Would you like to simulate Phase-2? (Y or N): ");
                    yesNo = userInput.next().charAt(0);
                    while (yesNo != 'Y' && yesNo != 'y' && yesNo != 'N' && yesNo != 'n') {
                        System.out.print("Please enter a valid choice: ");
                        yesNo = userInput.next().charAt(0);
                    }
                    if(yesNo == 'Y' || yesNo == 'y') {
                        simPhase2 = 'Y';
                    } else {
                        simPhase2 = 'N';
                    }

                    // Simulating Phase 1 if it has been selected
                    if(simPhase1 == 'Y') {
                        System.out.println("\nINITIALIZING PHASE 1 SIMULATION...");
                        TimeUnit.SECONDS.sleep(3);
                        // Creating simulation object
                        Simulation phase1Sim = new Simulation();
                        // Ask for which rocket to use for the phase
                        System.out.print("\nPhase 1 Initialized. Which rocket would you like to use? (U1 or U2): ");
                        rocketToUse = userInput.next().toUpperCase();
                        while (!rocketToUse.equals("U1") && !rocketToUse.equals("U2")) {
                            System.out.print("Please enter a valid choice of rocket: ");
                            rocketToUse = userInput.next().toUpperCase();
                        }
                        if(rocketToUse.equals("U1")) {
                            ArrayList rocketFleet1 = phase1Sim.loadU1(phase1Sim.loadItems("phase-1"));
                            budget = phase1Sim.runSimulation(rocketFleet1);
                            System.out.println("\nRunning Phase 1 Simulation with the U1 Rocket...");
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println(("TOTAL BUDGET NEEDED FOR PHASE 1 - U1 ROCKET: $" + budget + " MILLION"));
                        } else {
                            ArrayList rocketFleet2 = phase1Sim.loadU2(phase1Sim.loadItems("phase-1"));
                            budget = phase1Sim.runSimulation(rocketFleet2);
                            System.out.println("Running Phase 1 Simulation with the U2 Rocket...");
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println(("TOTAL BUDGET NEEDED FOR PHASE 1 - U2 ROCKET: $" + budget + " MILLION"));
                        }
                    }

                    // Waiting a few seconds before Phase 2 options load
                    TimeUnit.SECONDS.sleep(5);

                    // Simulating Phase 2 if it has been selected
                    if(simPhase2 == 'Y') {
                        System.out.println("\nINITIALIZING PHASE 2 SIMULATION...");
                        TimeUnit.SECONDS.sleep(3);
                        // Creating simulation object
                        Simulation phase2Sim = new Simulation();
                        // Ask for which rocket to use for the phase
                        System.out.print("\nPhase 2 Initialized. Which rocket would you like to use? (U1 or U2): ");
                        rocketToUse = userInput.next().toUpperCase();
                        while (!rocketToUse.equals("U1") && !rocketToUse.equals("U2")) {
                            System.out.print("Please enter a valid choice of rocket: ");
                            rocketToUse = userInput.next().toUpperCase();
                        }
                        if(rocketToUse.equals("U1")) {
                            ArrayList rocketFleet3 = phase2Sim.loadU1(phase2Sim.loadItems("phase-2"));
                            budget = phase2Sim.runSimulation(rocketFleet3);
                            System.out.println("\nRunning Phase 2 Simulation with the U1 Rocket...");
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println(("TOTAL BUDGET NEEDED FOR PHASE 2 - U1 ROCKET: $" + budget + " MILLION"));
                        } else {
                            ArrayList rocketFleet4 = phase2Sim.loadU2(phase2Sim.loadItems("phase-2"));
                            budget = phase2Sim.runSimulation(rocketFleet4);
                            System.out.println("Running Phase 2 Simulation with the U2 Rocket...");
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println(("TOTAL BUDGET NEEDED FOR PHASE 2 - U2 ROCKET: $" + budget + " MILLION"));
                        }
                    }
                    break;

                case '2':
                    // AI advises on rocket type to use

                    // Preparation
                    // Phase 1 - U1 Simulation
                    Simulation phase1SimU1;
                    // Phase 1 - U2 Simulation
                    Simulation phase1SimU2;
                    // Phase 2 - U1 Simulation
                    Simulation phase2SimU1;
                    // Phase 2 - U2 Simulation
                    Simulation phase2SimU2;
                    // Rocket fleet ArrayList for Phase 1 - U1 Rocket
                    ArrayList rocketFleetPhase1U1 = new ArrayList<U1>();
                    // Rocket fleet ArrayList for Phase 1 - U2 Rocket
                    ArrayList rocketFleetPhase1U2 = new ArrayList<U2>();
                    // Rocket fleet ArrayList for Phase 2 - U1 Rocket
                    ArrayList rocketFleetPhase2U1 = new ArrayList<U1>();
                    // Rocket fleet ArrayList for Phase 2 - U2 Rocket
                    ArrayList rocketFleetPhase2U2 = new ArrayList<U2>();
                    // Average budget for Phase 1 - U1 Rocket
                    double phase1_U1Budget = 0;
                    // Average budget for Phase 1 - U2 Rocket
                    double phase1_U2Budget = 0;
                    // Average budget for Phase 2 - U1 Rocket
                    double phase2_U1Budget = 0;
                    // Average budget for Phase 2 - U2 Rocket
                    double phase2_U2Budget = 0;
                    // String to show which rocket to use for Phase 1
                    String phase1RocketChoice;
                    // String to show which rocket to use for Phase 2
                    String phase2RocketChoice;
                    // Setting doneAnythingYet to true since user has chosen an active option
                    doneAnythingYet = true;

                    // Clearing terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Introduction
                    System.out.println("\nINITIALIZING PHASE 1 SIMULATION...");
                    TimeUnit.SECONDS.sleep(3);

                    // Simulating Phase 1 - U1 Rocket 1000 times to find the average budget.
                    System.out.println("\nLoading U1 Rockets...");
                    TimeUnit.SECONDS.sleep(3);
                    for(int i = 0; i < 1000; i++) {
                        // Creating simulation object
                        phase1SimU1 = new Simulation();
                        rocketFleetPhase1U1.clear();
                        rocketFleetPhase1U1 = phase1SimU1.loadU1(phase1SimU1.loadItems("phase-1"));
                        budget = phase1SimU1.runSimulation(rocketFleetPhase1U1);
                        phase1_U1Budget += budget;
                        System.out.println((i + 1) + " - Running Phase 1 Simulation with the U1 Rocket...");
                        System.out.println(((i + 1) + " - Budget Phase 1 - U1 ROCKET: $" + budget + " MILLION\n"));
                    }
                    // Clearing terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Results
                    System.out.println("\nProcessing results for Phase 1 - U1 Rocket");
                    TimeUnit.SECONDS.sleep(5);
                    // Dividing phase1_U1Budget by 1000 to get the average
                    phase1_U1Budget /= 1000;
                    System.out.println(("\nAVERAGE BUDGET NEEDED FOR PHASE 1 - U1 ROCKET: $" + phase1_U1Budget + " MILLION"));
                    TimeUnit.SECONDS.sleep(5);

                    // Simulating Phase 1 - U2 Rocket 1000 times to find the average budget.
                    System.out.println("\nLoading U2 Rockets...");
                    TimeUnit.SECONDS.sleep(3);
                    for(int i = 0; i < 1000; i++) {
                        // Creating simulation object
                        phase1SimU2 = new Simulation();
                        rocketFleetPhase1U2.clear();
                        rocketFleetPhase1U2 = phase1SimU2.loadU2(phase1SimU2.loadItems("phase-1"));
                        budget = phase1SimU2.runSimulation(rocketFleetPhase1U2);
                        phase1_U2Budget += budget;
                        System.out.println((i + 1) + " - Running Phase 1 Simulation with the U2 Rocket...");
                        System.out.println(((i + 1) + " - Budget Phase 1 - U2 ROCKET: $" + budget + " MILLION\n"));
                    }
                    // Clearing terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Results
                    System.out.println("\nProcessing results for Phase 1 - U2 Rocket");
                    TimeUnit.SECONDS.sleep(5);
                    // Dividing phase1_U2Budget by 1000 to get the average
                    phase1_U2Budget /= 1000;
                    System.out.println(("\nAVERAGE BUDGET NEEDED FOR PHASE 1 - U2 ROCKET: $" + phase1_U2Budget + " MILLION"));
                    TimeUnit.SECONDS.sleep(5);

                    // Clearing terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Introduction
                    System.out.println("\nINITIALIZING PHASE 2 SIMULATION...");
                    TimeUnit.SECONDS.sleep(3);

                    // Simulating Phase 2 - U1 Rocket 1000 times to find the average budget.
                    System.out.println("\nLoading U1 Rockets...");
                    TimeUnit.SECONDS.sleep(3);
                    for(int i = 0; i < 1000; i++) {
                        // Creating simulation object
                        phase2SimU1 = new Simulation();
                        rocketFleetPhase2U1.clear();
                        rocketFleetPhase2U1 = phase2SimU1.loadU1(phase2SimU1.loadItems("phase-2"));
                        budget = phase2SimU1.runSimulation(rocketFleetPhase2U1);
                        phase2_U1Budget += budget;
                        System.out.println((i + 1) + " - Running Phase 2 Simulation with the U1 Rocket...");
                        System.out.println(((i + 1) + " - Budget Phase 2 - U1 ROCKET: $" + budget + " MILLION\n"));
                    }
                    // Clearing terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Results
                    System.out.println("Processing results for Phase 2 - U1 Rocket");
                    TimeUnit.SECONDS.sleep(5);
                    // Dividing phase2_U1Budget by 1000 to get the average
                    phase2_U1Budget /= 1000;
                    System.out.println(("\nAVERAGE BUDGET NEEDED FOR PHASE 2 - U1 ROCKET: $" + phase2_U1Budget + " MILLION"));
                    TimeUnit.SECONDS.sleep(5);

                    // Simulating Phase 2 - U2 Rocket 1000 times to find the average budget.
                    System.out.println("\nLoading U2 Rockets...");
                    TimeUnit.SECONDS.sleep(3);
                    for(int i = 0; i < 1000; i++) {
                        // Creating simulation object
                        phase2SimU2 = new Simulation();
                        rocketFleetPhase2U2.clear();
                        rocketFleetPhase2U2 = phase2SimU2.loadU2(phase2SimU2.loadItems("phase-2"));
                        budget = phase2SimU2.runSimulation(rocketFleetPhase2U2);
                        phase2_U2Budget += budget;
                        System.out.println((i + 1) + " - Running Phase 2 Simulation with the U2 Rocket...");
                        System.out.println(((i + 1) + " - Budget Phase 2 - U2 ROCKET: $" + budget + " MILLION\n"));
                    }
                    // Clearing terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Results
                    System.out.println("Processing results for Phase 2 - U2 Rocket");
                    TimeUnit.SECONDS.sleep(5);
                    // Dividing phase2_U2Budget by 1000 to get the average
                    phase2_U2Budget /= 1000;
                    System.out.println(("\nAVERAGE BUDGET NEEDED FOR PHASE 2 - U2 ROCKET: $" + phase2_U2Budget + " MILLION"));
                    TimeUnit.SECONDS.sleep(5);

                    // SUMMARY
                    // Deciding rocket to use for Phase 1
                    if(phase1_U1Budget < phase1_U2Budget) {
                        phase1RocketChoice = "U1";
                    } else if(phase1_U2Budget < phase1_U1Budget) {
                        phase1RocketChoice = "U2";
                    } else {
                        phase1RocketChoice = "Either";
                    }
                    // Deciding rocket to use for Phase 2
                    if(phase2_U1Budget < phase2_U2Budget) {
                        phase2RocketChoice = "U1";
                    } else if(phase2_U2Budget < phase2_U1Budget) {
                        phase2RocketChoice = "U2";
                    } else {
                        phase2RocketChoice = "Either";
                    }
                    // Clearing terminal
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // AI SUMMARY
                    System.out.println("    _     _______  _______                                        _        _______\n   / \\       |    |        |        | |\\      /| |\\      /|      / \\      |       | \\       /\n  /   \\      |    |        |        | | \\    / | | \\    / |     /   \\     |       |  \\     /\n /-----\\     |    |______  |        | |  \\  /  | |  \\  /  |    /     \\    |_______|   \\   /\n/       \\ ___|___        | |        | |   \\/   | |   \\/   |   /-------\\   |\\__         \\_/\n                         | |        | |        | |        |  /         \\  |   \\__       |\n                  _______|  \\______/  |        | |        | /           \\ |      \\_     |");
//                System.out.println("    _     _______  _______                                        _        _______");
//                System.out.println("   / \\       |    |        |        | |\\      /| |\\      /|      / \\      |       | \\       /");
//                System.out.println("  /   \\      |    |        |        | | \\    / | | \\    / |     /   \\     |       |  \\     /");
//                System.out.println(" /-----\\     |    |______  |        | |  \\  /  | |  \\  /  |    /     \\    |_______|   \\   /");
//                System.out.println("/       \\ ___|___        | |        | |   \\/   | |   \\/   |   /-------\\   |\\__         \\_/");
//                System.out.println("                         | |        | |        | |        |  /         \\  |   \\__       |");
//                System.out.println("                  _______|  \\______/  |        | |        | /           \\ |      \\_     |");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("\nThe average budget needed for PHASE 1 - U1 ROCKET: $" + phase1_U1Budget + " Million");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("\nThe average budget needed for PHASE 1 - U2 ROCKET: $" + phase1_U2Budget + " Million");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("\nThe average budget needed for PHASE 2 - U1 ROCKET: $" + phase2_U1Budget + " Million");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("\nThe average budget needed for PHASE 2 - U2 ROCKET: $" + phase2_U2Budget + " Million");
                    TimeUnit.SECONDS.sleep(2);
                    // Phase 1 Rocket choice
                    if(!phase1RocketChoice.equals("Either")) {
                        System.out.println("\n\nRECOMMENDED ROCKET FOR PHASE 1: " + phase1RocketChoice + " Rocket");
                    } else {
                        System.out.println("\n\nEITHER ROCKET RECOMMENDED FOR PHASE 1.");
                        System.out.println("RUN SIMULATION AGAIN TO SEE IF THIS CHANGES.");
                    }
                    // Phase 2 rocket choice
                    if(!phase2RocketChoice.equals("Either")) {
                        System.out.println("\nRECOMMENDED ROCKET FOR PHASE 2: " + phase2RocketChoice + " Rocket");
                    } else {
                        System.out.println("\nEITHER ROCKET RECOMMENDED FOR PHASE 2.");
                        System.out.println("RUN SIMULATION AGAIN TO SEE IF THIS CHANGES.");
                    }
                    // Displaying the total budget required
                    if(!phase1RocketChoice.equals("Either") && !phase2RocketChoice.equals("Either")) {
                        // Total average budget
                        double totalAvgBudget = 0;

                        switch(phase1RocketChoice) {
                            case "U1":
                                totalAvgBudget += phase1_U1Budget;
                                break;

                            case "U2":
                                totalAvgBudget += phase1_U2Budget;
                                break;
                        }
                        switch(phase2RocketChoice) {
                            case "U1":
                                totalAvgBudget += phase2_U1Budget;
                                break;

                            case "U2":
                                totalAvgBudget += phase2_U2Budget;
                                break;
                        }
                        if(totalAvgBudget >= 1000) {
                            totalAvgBudget /= 1000;
                            System.out.println("\nTOTAL AVERAGE BUDGET: $" + totalAvgBudget + " Billion");
                        } else {
                            System.out.println("\nTOTAL AVERAGE BUDGET: $" + totalAvgBudget + " Million");
                        }
                    }
                    break;

                case '3': default:
                    // Information about the software

                    // Preparation
                    // Phase 1 Items
                    File phase1ItemList = new File("src/com/RoBroTech/Dev/SpaceChallenge/phase-1.txt");
                    // Phase 2 Items
                    File phase2ItemList = new File("src/com/RoBroTech/Dev/SpaceChallenge/phase-2.txt");
                    // Scanner to read phase 1 items list
                    Scanner phase1ItemListScanner = new Scanner(phase1ItemList);
                    // Scanner to read phase 2 items list
                    Scanner phase2ItemListScanner = new Scanner(phase2ItemList);
                    // String to hold each line of the phase 1 item list for manipulation
                    String tmpLineHolder;
                    // Temporary item name string
                    char[] tmpItemName;
                    // Final item name
                    String finalItemName;
                    // Temporary int for the number of letters in item name
                    int tmpItemNameNumOfLetters;
                    // Temporary item weight string
                    char[] tmpItemWeight;
                    // String for the item weight
                    String finalItemWeight;
                    // Temporary int for the number of letters in item weight
                    int tmpItemWeightNumOfLetters;
                    // Boolean to show if the scanner has passed the equals sign
                    boolean passedEquals;
                    // The int to show which letter in line contains the equals sign
                    int equalsSignPosition = 0;

                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // Copyright of the software
                    System.out.println("\nCopyright (c) 2019 RoBro Tech. All rights reserved.");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("\nRoBro Tech is the Developer Company of Rohan Mathew.");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // Software information
                    // Rocket information
                    System.out.println("\n\nThis software revolves around two types of rockets: U1 and U2.");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Their properties will be listed after you continue.");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // U1 facts
                    System.out.println("\nU1");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nCOST: $100,000,000");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("WEIGHT: 10,000 KG");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("MAXIMUM WEIGHT: 18,000 KG");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Chance Of Launch Explosion = 5% * (Cargo Carried / Cargo Limit)");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Chance Of Landing Crash = 1% * (Cargo Carried / Cargo Limit)");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // U2 facts
                    System.out.println("\nU2");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nCOST: $120,000,000");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("WEIGHT: 18,000 KG");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("MAXIMUM WEIGHT: 29,000 KG");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Chance Of Launch Explosion = 4% * (Cargo Carried / Cargo Limit)");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Chance Of Landing Crash = 8% * (Cargo Carried / Cargo Limit)");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // Phases
                    System.out.println("\n\nThis software also bases its simulations on two phases.");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("More information about them will be provided after you continue.");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // Phase 1 info
                    System.out.println("\nPHASE 1");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nThe items to carry in this phase: \n");
                    while(phase1ItemListScanner.hasNextLine()) {
                        // Prep
                        tmpLineHolder = phase1ItemListScanner.nextLine();
                        tmpItemNameNumOfLetters = 0;
                        tmpItemWeightNumOfLetters = 0;
                        passedEquals = false;

                        // Counting number of letters in name and weight
                        for(int i = 0; i < tmpLineHolder.length(); i++) {
                            if(tmpLineHolder.charAt(i) != '=' && !passedEquals) {
                                tmpItemNameNumOfLetters++;
                            } else if(passedEquals && tmpLineHolder.charAt(i) != '=') {
                                tmpItemWeightNumOfLetters++;
                            } else if(tmpLineHolder.charAt(i) == '=') {
                                passedEquals = true;
                                equalsSignPosition = i;
                            }
                        }
                        // Initializing chars name and weight with number of letters obtained.
                        tmpItemName = new char[tmpItemNameNumOfLetters];
                        tmpItemWeight = new char[tmpItemWeightNumOfLetters];
                        // Assigining values from the list line into name or weight.
                        passedEquals = false;
                        for(int i = 0; i < tmpLineHolder.length(); i++) {
                            if(tmpLineHolder.charAt(i) != '=' && !passedEquals) {
                                tmpItemName[i] = tmpLineHolder.toUpperCase().charAt(i);
                            } else if(passedEquals && tmpLineHolder.charAt(i) != '=') {
                                tmpItemWeight[i - equalsSignPosition - 1] = tmpLineHolder.charAt(i);
                            } else if(tmpLineHolder.charAt(i) == '=') {
                                passedEquals = true;
                            }
                        }
                        // Converting the name to a String and weight to double
                        finalItemName = new String(tmpItemName);
                        finalItemWeight = new String(tmpItemWeight);

                        // Printing the name and weight of item
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("\nItem: " + finalItemName + "\nItem Weight: " + finalItemWeight + " KG");
                    }
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    // Phase 2 info
                    System.out.println("\nPHASE 2");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\n The items to carry in this phase: \n");
                    while(phase2ItemListScanner.hasNextLine()) {
                        // Prep
                        tmpLineHolder = phase2ItemListScanner.nextLine();
                        tmpItemNameNumOfLetters = 0;
                        tmpItemWeightNumOfLetters = 0;
                        passedEquals = false;

                        // Counting number of letters in name and weight
                        for(int i = 0; i < tmpLineHolder.length(); i++) {
                            if(tmpLineHolder.charAt(i) != '=' && !passedEquals) {
                                tmpItemNameNumOfLetters++;
                            } else if(passedEquals && tmpLineHolder.charAt(i) != '=') {
                                tmpItemWeightNumOfLetters++;
                            } else if(tmpLineHolder.charAt(i) == '=') {
                                passedEquals = true;
                                equalsSignPosition = i;
                            }
                        }
                        // Initializing chars name and weight with number of letters obtained.
                        tmpItemName = new char[tmpItemNameNumOfLetters];
                        tmpItemWeight = new char[tmpItemWeightNumOfLetters];
                        // Assigning values from the list line into name or weight.
                        passedEquals = false;
                        for(int i = 0; i < tmpLineHolder.length(); i++) {
                            if(tmpLineHolder.charAt(i) != '=' && !passedEquals) {
                                tmpItemName[i] = tmpLineHolder.toUpperCase().charAt(i);
                            } else if(passedEquals && tmpLineHolder.charAt(i) != '=') {
                                tmpItemWeight[i - equalsSignPosition - 1] = tmpLineHolder.charAt(i);
                            } else if(tmpLineHolder.charAt(i) == '=') {
                                passedEquals = true;
                            }
                        }
                        // Converting the name to a String and weight to double
                        finalItemName = new String(tmpItemName);
                        finalItemWeight = new String(tmpItemWeight);

                        // Printing the name and weight of item
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("\nItem: " + finalItemName + "\nItem Weight: " + finalItemWeight + " KG");
                    }
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("\n\nThis software has two functional options:");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\n1 - Manual Rocket Parameter entry for isolated simulation.");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("2 - AI simulation of rockets on mass scale in order to work out the average.");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("\nOPTION 1 - MANUAL ROCKET PARAMETER ENTRY");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nThis option enables you to choose to simulate 1 rocket of your choice");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("in each phase that you select to simulate.");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("\nOPTION 2 - AI MASS SIMULATION OF ROCKETS");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nThis function of this option is to run 1000 simulations for each phase");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("for each of the rockets. The various simulation combinations are listed");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("1000 x Phase 1 - U1 Rocket");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("1000 x Phase 1 - U2 Rocket");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("1000 x Phase 2 - U1 Rocket");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("1000 x Phase 2 - U2 Rocket");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    System.out.println("\nThis allows for each of the four combinations, an average budget");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("is calculated. Based on this, the software will display the recommended");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("rockets to use at the end of the simulations.");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to continue: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    System.out.println("THANK YOU FOR USING THE SPACECHALLENGE SIMULATOR! 😎");
                    TimeUnit.SECONDS.sleep(5);
                    // Continue prompt
                    System.out.print("\n\nPress any letter and press Enter to return to the main menu: ");
                    userInput.next().charAt(0);
                    // Looping for blank screen
                    for(int i = 0; i < 100; i++) {
                        System.out.println("\n");
                    }
                    break;
            }
        }
    }
}
