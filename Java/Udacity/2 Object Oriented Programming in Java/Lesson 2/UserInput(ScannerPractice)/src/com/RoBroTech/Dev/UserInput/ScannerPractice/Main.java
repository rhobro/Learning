/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: UserInput(ScannerPractice)
 * File Name: Main.java
 * Last Modified: 08/05/19 20:53
 */

package com.RoBroTech.Dev.UserInput.ScannerPractice;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your address: ");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        System.out.println("You live at: " + address);
    }
}
