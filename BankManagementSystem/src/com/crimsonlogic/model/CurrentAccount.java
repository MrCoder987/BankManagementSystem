package com.crimsonlogic.model;

public class CurrentAccount extends BankAccount {
    public static final double MONTHLY_FEE = 100.0;

    @Override
    public void applyMonthlyFee() {
        if (balance - MONTHLY_FEE >= minBal) {
            balance -= MONTHLY_FEE;
        } else {
            System.out.println("Cannot apply monthly fee, minimum balance requirement not met.");
        }
    }

    @Override
    public void applyInterest() {
        System.out.println("Interest application is not supported for Current Account.");
    }
}
