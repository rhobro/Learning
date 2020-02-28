/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: MoviesGuessingGame
 * File Name: Main.java
 * Last Modified: 08/05/19 20:25
 */

package com.RoBroTech.Dev.MovieGuessingGame;

import java.util.Scanner;

// Main class
public class Main {

    // main method
    public static void main(String[] args) {

        // Preparation
        // Scanner to read the User's guesses
        Scanner userInput = new Scanner(System.in);
        // The User's choice of game difficulty ("E" or "H"). It is initialized to "河蟹 Artwork" to prevent any initialization errors. Find out what is special about "河蟹 Artwork" on Google.
        String howDifficult;
        // The difficulty arg which will be supplied to the Game constructor based on howDifficult. Default is "LHOOQ". See what it means!
        String gameStartSubmit;
        // The guess character
        char userGuess;

        // Introduction
        System.out.println("Welcome to the Movie Guessing Game");
        System.out.println("\nThere are two versions: an easy and hard version");
        System.out.println("The differences are that the movies will be harder to guess,");
        System.out.println("you will have to guess its release date and you will");
        System.out.println("have to add capital letters where required as well as any punctuation.");
        // User has to choose game difficulty.
        System.out.print("\nWould you like to play the easy or hard version? (E or H) ");
        howDifficult = userInput.nextLine();
        // Checking the User answered with a valid answer
        while (!howDifficult.equals("e") && !howDifficult.equals("E") && !howDifficult.equals("h") && !howDifficult.equals("H")) {
            System.out.print("Please enter a valid response for the game difficulty: ");
            howDifficult = userInput.nextLine();
        }
        // Converting User choice of difficulty to an arg that the Game constructor understands.
        if(howDifficult.equals("e") || howDifficult.equals("E")) {
            gameStartSubmit = "easy";
        } else {
            gameStartSubmit = "hard";
        }
        System.out.println("\nENJOY!\n");

        // Creating Game object
        Game movieGuessingGame = new Game(gameStartSubmit);
        // Integer to store value for the userGuessCheck method of the Game object
        int userGuessCheckResponse;
        // Loop lasting the duration of the game when the User is making their guesses
        while(!movieGuessingGame.getHasWon() && !movieGuessingGame.getHasLost()) {
            // Printing to User, their guessing information: movie to guess and number of wrong guesses.
            if(movieGuessingGame.getGameDifficulty().equals("hard")) {
                System.out.println("\n                  Y E A R         M O V I E   N A M E");
            }
            System.out.println("You are guessing: " + movieGuessingGame.getDisplayUnderscoreMovie());
            System.out.print("You have guessed (" + movieGuessingGame.getWrongGuessesCount() + ") wrong letters: ");
            for(int i = 0; i < movieGuessingGame.getWrongGuessesCount(); i++) {
                System.out.print(movieGuessingGame.getWrongGuesses(i) + " ");
            }
            //Prompt for User to make a guess
            System.out.print("\nGuess a letter: ");
            userGuess = userInput.next().charAt(0);
            userGuessCheckResponse = movieGuessingGame.userGuessCheck(userGuess);
            // Switch for the different outputs for the result of userGuessCheck.
            switch (userGuessCheckResponse) {

                case 0:
                    // User has submitted a blank guess
                    while(userGuess == ' ' || (int) userGuess == 0) {
                        System.out.print("\nYou have not submitted your guess. Try again: ");
                        userGuess = userInput.next().charAt(0);
                        userGuessCheckResponse = movieGuessingGame.userGuessCheck(userGuess);
                        break;
                    }
                    break;

                case 1:
                    // User submitted a guess they have already made.
                    while(movieGuessingGame.userGuessCheck(userGuess) == 1) {
                        if(movieGuessingGame.userGuessCheck(userGuess) != 1) {
                            break;
                        }
                        System.out.print("Please make another guess: ");
                        userGuess = userInput.next().charAt(0);
                    }
                    System.out.print("\nYou have already guessed this. Try again: ");
                    userGuess = userInput.next().charAt(0);
                    userGuessCheckResponse = movieGuessingGame.userGuessCheck(userGuess);
                    break;

                case 2:
                    // User made a correct guess
                    System.out.println("\nWell done. That was a correct guess.\n");
                    break;

                case 3:
                    // User made a wrong guess
                    System.out.println("\nUnfortunately, that was an incorrect guess.\n");
                    break;

                case 4:
                    // User has won the game. Game ends.
                    System.out.println("\nYou know your movies!");
                    if(movieGuessingGame.getGameDifficulty().equals("hard")) {
                        System.out.println("\n             DATE    MOVIE NAME");
                    }
                    System.out.println("You guessed '" + movieGuessingGame.getMovieName() + "' correctly!");
                    break;

                case 5:
                    // User has lost the game. Game ends.
                    System.out.println("\nYou need to brush up on your film knowledge");
                    if(movieGuessingGame.getGameDifficulty().equals("hard")) {
                        System.out.println("\n             DATE    MOVIE NAME");
                    }
                    System.out.println("You guessed '" + movieGuessingGame.getMovieName() + "' wrongly.");
                    break;

                default:
                    // The default path if the userGuessCheckResponse value is invalid.
                    throw new IllegalStateException("Unexpected value of: " + userGuessCheckResponse);
            }
        }
    }
}