/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: Person(StaticPractice)
 * File Name: Person.java
 * Last Modified: 11/04/19 16:36
 */

package com.RoBroTech.Dev.Person.StaticPractice;

public class Person {

    // Member fields
    public static int instanceCount;
    public int localCount;

    // Constructor
    public Person() {
        instanceCount++;
        localCount++;
    }
}
