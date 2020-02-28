/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: Person(StaticPractice)
 * File Name: Main.java
 * Last Modified: 11/04/19 16:37
 */

package com.RoBroTech.Dev.Person.StaticPractice;

public class Main {

    public static void main(String[] args) {

        // Make new person objects
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();

        // Print the values of the counters
        System.out.println("(" + person4.localCount + "," + Person.instanceCount + ")");
    }
}
