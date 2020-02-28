/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: NumberGame
 * File Name: NumberGame.java
 * Last Modified: 08/05/19 20:48
 */

package com.RoBroTech.Dev.NumberGame;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;

        System.out.println("I have chosen a number between 1 ans 100");
        System.out.println("Try to guess it.");

        Scanner userGuess = new Scanner(System.in);
        for(int i = 10; i > 0; i--) {
            System.out.println("You have " + i + " guess(es) left. Try again: ");
            int guess = userGuess.nextInt();
            if(randomNumber > guess) {
                System.out.println("Your guess is smaller than my number.");
            } else if(randomNumber < guess) {
                System.out.println("Your guess is greater that my number.");
            } else {
                hasWon = true;
                break;
            }
        }

        if(hasWon) {
            System.out.println("CORRECT... YOU WON!!!");
        } else {
            System.out.println("UNLUCKY... YOU LOST!!!");
        }
    }
}
