package com.crimsonlogic.model;

import com.crimsonlogic.exception.InsufficientFundsException;

public abstract class BankAccount implements Account {
	protected double balance = 0;

	@Override
	public double getBalance(int userId) {
		return balance;
	}

	@Override
	public double deposit(double depositAmt) {
		balance += depositAmt;
		return balance;
	}

	@Override
	public double withdraw(double withdrawAmt) {
		try {
			if (balance - withdrawAmt >= minBal) {
				balance -= withdrawAmt;
				return balance;
			} else {
				throw new InsufficientFundsException("Withdrawal denied. Minimum balance requirement not met.");
			}
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
			return balance;
		}
	}

	@Override
	public void applyMonthlyFee() {
		System.out.println("Monthly fee application not supported for this account type.");
	}

	@Override
	public void applyInterest() {
		System.out.println("Interest application not supported for this account type.");
	}
}
