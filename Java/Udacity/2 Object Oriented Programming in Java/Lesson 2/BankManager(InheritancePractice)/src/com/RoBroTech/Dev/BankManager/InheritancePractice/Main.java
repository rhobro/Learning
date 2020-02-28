/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: BankManager(InheritancePractice)
 * File Name: Main.java
 * Last Modified: 08/05/19 20:41
 */

package com.RoBroTech.Dev.BankManager.InheritancePractice;

public class Main {
    public static void main(String[] args) {
        BankAccount checkingAccount = new CheckingAccount();
        BankAccount savingsAccount = new SavingsAccount();
        CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit();
        checkingAccount.account = 1234;
        savingsAccount.balance = 8273483;
        certificateOfDeposit.limit = 3920;
    }
}
