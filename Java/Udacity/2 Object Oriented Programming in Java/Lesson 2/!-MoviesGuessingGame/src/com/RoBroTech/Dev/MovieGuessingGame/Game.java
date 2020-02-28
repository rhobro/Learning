/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: MoviesGuessingGame
 * File Name: Game.java
 * Last Modified: 08/05/19 20:25
 */

package com.RoBroTech.Dev.MovieGuessingGame;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Scanner;

public class Game {

    // com.RoBroTech.Dev.Game - Member fields

    // The random movie object which was generated.
    private Movie chosenMovie;
    // The modified version of the movie which will be displayed to the User with underscores in place of letters.
    private String displayUnderscoreMovie;
    // Boolean for whether the User has won.
    private boolean hasWon = false;
    // Boolean for whether the User has lost.
    private boolean hasLost = false;
    // Counter for the number of wrong guesses made by the User.
    private int wrongGuessesCount = 0;
    // A temporary char array in order to assist with conversion between the real movie name and underscore name.
    private char[] tmpConversion;
    // A temporary char array to hold the movie name while conversions take place
    private char[] tmpNameHolder;
    // Stores all correct guesses
    private char[] correctGuesses = new char[1000];
    // Keeps track of what cell number the new correct guess needs to be assigned.
    private int correctGuessesIndex = 0;
    // Stores all wrong guesses
    private char[] wrongGuesses = new char[10];
    // Keeps track of what cell number the wrong guess needs to be assigned.
    private int wrongGuessesIndex = 0;
    // A counter for when conversions take place
    private int conversionCount = 0;
    // A char showing the game difficulty.
    private String gameDifficulty;

    // A nested Movie class for the movie object
    private class Movie {

        // com.RoBroTech.Dev.Game.Movie - Member fields

        // The name of the random Movie
        private String name;

        // DEFAULT Object Constructor - Choose random movie with default EASY difficulty.
        private Movie() throws Exception {

            // Preparation

            // File with a path to the list of EASY movies.
            File easyMovieList =  new File("src/com/RoBroTech/Dev/MovieGuessingGame/easy-movies.txt");
            // Scanner to read list of easy movies.
            Scanner movieListScanner = new Scanner(easyMovieList);
            int lineCount = 0;
            // Counting number of movies in the list.
            while(movieListScanner.hasNextLine()) {
                lineCount++;
            }
            // Reset the scanner to read file from the top again
            movieListScanner.reset();
            // Initialize the array to the number of lines in the movie list.
            String[] movieArray = new String[lineCount];

            // Adding movies from the list into the array
            for(int i = 0; i < lineCount; i++) {
                movieArray[i] = movieListScanner.nextLine();
            }

            // Calculating random movieArray cell number to use.
            int arrayCellNum = (int) (Math.random() * lineCount);
            this.name = movieArray[arrayCellNum];
        }

        // Object Constructor - Choose random movie with CUSTOMIZABLE DIFFICULTY
        private Movie(@NotNull String difficultyOfMovie) throws Exception {

            // Preparation

            // List of easy movies.
            File easyMovieList =  new File("src/com/RoBroTech/Dev/MovieGuessingGame/easy-movies.txt");
            // Scanner to read the list of easy movies.
            Scanner easyMovieListScanner = new Scanner(easyMovieList);
            // List of hard movies.
            File hardMovieList = new File("src/com/RoBroTech/Dev/MovieGuessingGame/hard-movies.txt");
            // Scanner to read the list of hard movies.
            Scanner hardMovieListScanner = new Scanner(hardMovieList);
            // Array of all movies in the list
            String[] movieArray;
            // Number of lines in the list of movies
            int lineCount;
            // The random cell of the movie list array.
            int arrayCellNum;

            // Switching path to take based on the User's choice of game difficulty
            switch(difficultyOfMovie) {

                case "easy":
                    // Path to take if game difficulty is easy.
                    lineCount = 0;
                    // Counting number of movies in the list.
                    while(easyMovieListScanner.hasNextLine()) {
                        lineCount++;
                        if(easyMovieListScanner.nextLine() == null) {
                            break;
                        }
                    }
                    // Initialize the array to the number of lines in the movie list.
                    movieArray = new String[lineCount];

                    // New scanner to input the variables into the movie array
                    Scanner movieArrayInputEASY = new Scanner(easyMovieList);
                    // Adding movies from the list into the array
                    for(int i = 0; i < lineCount; i++) {
                        movieArray[i] = movieArrayInputEASY.nextLine();
                    }
                    break;

                case "hard":
                    // Path to take if game difficulty is hard.
                    lineCount = 0;
                    // Counting number of movies in the list.
                    while(hardMovieListScanner.hasNextLine()) {
                        lineCount++;
                        if(hardMovieListScanner.nextLine() == null) {
                            break;
                        }
                    }
                    // Initialize the array to the number of lines in the movie list.
                    movieArray = new String[lineCount];

                    // New scanner to input the variables into the movie array
                    Scanner movieArrayInputHARD = new Scanner(hardMovieList);
                    // Adding movies from the list into the array
                    for(int i = 0; i < lineCount; i++) {
                        movieArray[i] = movieArrayInputHARD.nextLine();
                    }
                    break;

                // The default path if the game difficulty value is invalid.
                default:
                    throw new IllegalStateException("Unexpected value of: " + difficultyOfMovie);
            }
            // Calculating random movieArray cell number to use.
            arrayCellNum = (int) (Math.random() * lineCount);
            this.name = movieArray[arrayCellNum];
        }
    }


    // com.RoBroTech.Dev.Game DEFAULT Constructor
    public Game() {
        try {
            this.chosenMovie = new Movie();
        } catch(Exception exception) {
            System.out.println("There was an error in choosing the movie.");
        }
        this.gameDifficulty = "easy";

        // Assigning the chosen movie's name to the underscore movie name with a space between the characters.
        this.tmpNameHolder = this.chosenMovie.name.toCharArray();
        this.tmpConversion = new char[this.chosenMovie.name.length() * 2];
        this.conversionCount = 0;
        for(int i = 0; i < this.tmpNameHolder.length; i++) {
            this.tmpConversion[this.conversionCount] = this.tmpNameHolder[i];
            this.conversionCount += 2;
        }
        // Replacing letters with underscores
        for(int i = 0; i < this.tmpConversion.length; i++) {
            if((int) this.tmpConversion[i] == 0) {
                this.tmpConversion[i] = ' ';
            } else if(this.tmpConversion[i] != ' ') {
                this.tmpConversion[i] = '_';
            }
        }
        // Assigning the underscored movie name in the char array to the underscore movie name.
        this.displayUnderscoreMovie = new String(this.tmpConversion);
    }

    // com.RoBroTech.Dev.Game Constructor with CUSTOMIZABLE DIFFICULTY.
    public Game(String difficultyOfGame) {
        try {
            this.chosenMovie = new Movie(difficultyOfGame);
        } catch(Exception exception) {
            System.out.println("There was an error in choosing the Movie.");
        }
        this.gameDifficulty = difficultyOfGame;

        // Assigning the chosen movie's name to the underscore movie name with a space between the characters.
        this.tmpNameHolder = this.chosenMovie.name.toCharArray();
        this.tmpConversion = new char[this.chosenMovie.name.length() * 2];
        this.conversionCount = 0;
        for(int i = 0; i < this.tmpNameHolder.length; i++) {
            this.tmpConversion[this.conversionCount] = this.tmpNameHolder[i];
            this.conversionCount += 2;
        }
        // Replacing letters with underscores
        for(int i = 0; i < this.tmpConversion.length; i++) {
            if((int) this.tmpConversion[i] == 0) {
                this.tmpConversion[i] = ' ';
            } else if(this.tmpConversion[i] != ' ') {
                this.tmpConversion[i] = '_';
            }
        }
        // Assigning the underscored movie name in the char array to the underscore movie name.
        this.displayUnderscoreMovie = new String(this.tmpConversion);
    }


    // com.RoBroTech.Dev.Game method to check if the User's guess is correct.
    /* Key for number return values
    0 - User hasn't entered their guess
    1 - User has already guessed this
    2 - Correct
    3 - Wrong
    4 - User WON
    5 - User LOST
    6 - Alright so far
     */
    public int userGuessCheck(char guess) {
        int functionResponse = 6;
        int charNull = guess;
        boolean notABlank = false;
        boolean guessSubmittedSoFar = false;
        boolean guessIsStillWrong = false;
        boolean lettersRemainingToGuess = true;
        boolean doNotChange = false;

        if(charNull != 0 || guess != ' ') {
            // Checking that the guess is not blank or just a space
            notABlank = true;

            if(notABlank) {
                //Checking the guess has not already been made
                for(int i = 0; i < this.correctGuessesIndex; i++) {
                    if(guess == this.correctGuesses[i]) {
                        guessSubmittedSoFar = true;
                        // User has already guessed this correctly
                        functionResponse = 1;
                        break;
                    }
                }
                for(int i = 0; i < this.wrongGuessesIndex; i++) {
                    if(guess == this.wrongGuesses[i]) {
                        guessSubmittedSoFar = true;
                        // User has already guessed this wrongly
                        functionResponse = 1;
                        break;
                    }
                }
                if(!guessSubmittedSoFar) {
                    //Looping through the array to check if the guess matches any of the letters
                    this.displayUnderscoreMovie = this.chosenMovie.name;
                    this.tmpConversion = this.displayUnderscoreMovie.toCharArray();
                    for(int i = 0; i < this.tmpConversion.length; i++) {
                        if(this.tmpConversion[i] == guess) {
                            guessIsStillWrong = false;
                            this.correctGuesses[this.correctGuessesIndex] = guess;
                            this.correctGuessesIndex++;

                            // Rebuilding displayUnderscoreMovie
                            // Assigning the chosen movie's name to the underscore movie name with a space between the characters.
                            this.tmpNameHolder = this.chosenMovie.name.toCharArray();
                            this.tmpConversion = new char[this.chosenMovie.name.length() * 2];
                            this.conversionCount = 0;
                            for(int j = 0; j < this.tmpNameHolder.length; j++) {
                                this.tmpConversion[this.conversionCount] = this.tmpNameHolder[j];
                                this.conversionCount += 2;
                            }
                            // Replacing letters with underscores
                            for(int j = 0; j < this.tmpConversion.length; j++) {
                                doNotChange = false;
                                if(this.tmpConversion[j] != ' ' && (int) this.tmpConversion[j] != 0) {
                                    if(this.correctGuessesIndex > 0) {
                                        for(int k = 0; k < this.correctGuessesIndex; k++) {
                                            if(this.tmpConversion[j] == this.correctGuesses[k]) {
                                                doNotChange = true;
                                                break;
                                            } else {
                                                doNotChange = false;
                                            }
                                        }
                                    } else {
                                        doNotChange = false;
                                    }
                                } else if(this.tmpConversion[j] == ' ') {
                                    doNotChange = true;
                                } else if((int) this.tmpConversion[j] == 0) {
                                    this.tmpConversion[i] = ' ';
                                    doNotChange = true;
                                }
                                if(!doNotChange) {
                                    this.tmpConversion[j] = '_';
                                }
                            }
                            // Assigning the underscored movie name in the char array to the underscore movie name.
                            this.displayUnderscoreMovie = new String(this.tmpConversion);

                            // Checking if there are still letters to be guessed
                            for(int j = 0; j < this.tmpConversion.length; j++) {
                                if(this.tmpConversion[j] == '_' && this.tmpConversion[j] != ' ') {
                                    lettersRemainingToGuess = true;
                                    break;
                                } else {
                                    lettersRemainingToGuess = false;
                                }
                            }

                            // Checking if the User has won or has simply got the guess correct
                            if(lettersRemainingToGuess) {
                                // User got the guess correct
                                functionResponse = 2;
                            } else if(!lettersRemainingToGuess && this.wrongGuessesCount < 10) {
                                // User has WON the game
                                functionResponse = 4;
                                this.hasWon = true;
                                this.hasLost = false;
                            }
                            break;
                        } else if(this.tmpConversion[i] != guess) {
                            guessIsStillWrong = true;
                        }
                    }
                    // Checking if the User has got the guess wrong or has lost
                    if(guessIsStillWrong && wrongGuessesCount < 10) {
                        this.wrongGuesses[this.wrongGuessesIndex] = guess;
                        this.wrongGuessesIndex++;
                        this.wrongGuessesCount++;
                        // User got the guess wrong
                        functionResponse = 3;
                    }
                    if(wrongGuessesCount >= 10) {
                        // User LOST the game
                        functionResponse = 5;
                        this.hasLost = true;
                        this.hasWon = false;
                    }
                }
            }
        } else if(charNull == 0 || guess == ' ') {
            functionResponse = 0;
        }

        // Rebuilding displayUnderscoreMovie
        // Assigning the chosen movie's name to the underscore movie name with a space between the characters.
        this.tmpNameHolder = this.chosenMovie.name.toCharArray();
        this.tmpConversion = new char[this.chosenMovie.name.length() * 2];
        this.conversionCount = 0;
        for(int j = 0; j < this.tmpNameHolder.length; j++) {
            this.tmpConversion[this.conversionCount] = this.tmpNameHolder[j];
            this.conversionCount += 2;
        }
        // Replacing letters with underscores
        for(int i = 0; i < this.tmpConversion.length; i++) {
            doNotChange = false;
            if(this.tmpConversion[i] != ' ' && (int) this.tmpConversion[i] != 0) {
                if(this.correctGuessesIndex > 0) {
                    for(int j = 0; j < this.correctGuessesIndex; j++) {
                        if(this.tmpConversion[i] == this.correctGuesses[j]) {
                            doNotChange = true;
                            break;
                        } else {
                            doNotChange = false;
                        }
                    }
                } else {
                    doNotChange = false;
                }
            } else if(this.tmpConversion[i] == ' ') {
                doNotChange = true;
            } else if((int) this.tmpConversion[i] == 0) {
                this.tmpConversion[i] = ' ';
                doNotChange = true;
            }
            if(!doNotChange) {
                this.tmpConversion[i] = '_';
            }
        }
        // Assigning the underscored movie name in the char array to the underscore movie name.
        this.displayUnderscoreMovie = new String(this.tmpConversion);

        // Returning the value
        return functionResponse;
    }


    // Getters
    // displayUnderscoreMovie
    public String getDisplayUnderscoreMovie() {
        return this.displayUnderscoreMovie;
    }
    // hasWon
    public boolean getHasWon() {
        return this.hasWon;
    }
    // hasLost
    public boolean getHasLost() {
        return this.hasLost;
    }
    // wrongGuessesCount
    public int getWrongGuessesCount() {
        return this.wrongGuessesCount;
    }
    // wrongGuesses Array
    public char getWrongGuesses(int cellNumber) {
        return this.wrongGuesses[cellNumber];
    }
    // Get name of movie if User loses
    public String getMovieName() {
        if(this.hasLost || this.hasWon) {
            return this.chosenMovie.name;
        } else {
            return null;
        }
    }
    // Get difficulty of game
    public String getGameDifficulty() {
        return this.gameDifficulty;
    }
}