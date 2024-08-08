package com.crimsonlogic.model;

public class SavingsAccount extends BankAccount {
    public static final double INTEREST_RATE = 2.5;

    @Override
    public void applyMonthlyFee() {
        System.out.println("Monthly fee application is not supported for Savings Account.");
    }

    @Override
    public void applyInterest() {
        balance += balance * (INTEREST_RATE / 100);
    }
}
