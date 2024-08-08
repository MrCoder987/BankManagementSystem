package com.crimsonlogic.model;

public interface Account {
	double minBal = 6000d;
	double getBalance(int userId);
	double deposit(double depositAmt);
	double withdraw(double withdrawAmt);
	void applyMonthlyFee();
	void applyInterest();
}
