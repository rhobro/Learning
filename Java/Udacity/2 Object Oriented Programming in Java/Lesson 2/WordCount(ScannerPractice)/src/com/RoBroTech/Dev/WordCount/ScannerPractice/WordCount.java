/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: WordCount(ScannerPractice)
 * File Name: WordCount.java
 * Last Modified: 08/05/19 20:55
 */

package com.RoBroTech.Dev.WordCount.ScannerPractice;

import java.io.File;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws Exception {
        File plainTextBook = new File("src/com/RoBroTech/Dev/WordCount/ScannerPractice/ImportanceOfBeingEarnest.txt");
        Scanner bookScanner = new Scanner(plainTextBook);

        int words = 0;
        String lines;
        while(bookScanner.hasNextLine()) {
            lines = bookScanner.nextLine();
            words += lines.split(" ").length;
        }
        System.out.println("This book has " + words + " words.");
    }
}
