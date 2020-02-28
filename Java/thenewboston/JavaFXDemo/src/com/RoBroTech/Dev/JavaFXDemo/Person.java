/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: JavaFXDemo
 * File Name: Person.java
 * Last Modified: 12/08/19 13:34
 */

package com.RoBroTech.Dev.JavaFXDemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
