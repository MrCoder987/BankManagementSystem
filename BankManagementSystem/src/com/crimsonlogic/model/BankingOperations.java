package com.crimsonlogic.model;

import com.crimsonlogic.exception.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingOperations {
	static int bankOperation;
	Scanner sc = new Scanner(System.in);
	static List<User> userList = new ArrayList<>();
	static BankAccount bankAccount;

	public void readUserChoice() {
		System.out.println("Enter the user choice:");
		System.out.println("1. Register : to add new user");
		System.out.println("2. Login : to login as existing user");
		System.out.println("3. Exit");
		bankOperation = sc.nextInt();
	}

	public void bankingMenu() {
		readUserChoice();
		switch (bankOperation) {
			case 1:
				registerUser();
				break;
			case 2:
				loginUser();
				break;
			default:
				System.out.println("Exiting the system");
				break;
		}
	}

	public void bankingOptions(int userId) {
		int bankingOption;
		boolean running = true;

		while (running) {
			System.out.println("What do you want to do today?");
			System.out.println("1. Check balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Apply Monthly Fee");
			System.out.println("5. Get Monthly Fee");
			System.out.println("6. Apply Interest");
			System.out.println("7. Get Interest Rate");
			System.out.println("8. Exit");

			bankingOption = sc.nextInt();

            switch (bankingOption) {
                case 1:
                    getBalance(userId);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    if (bankAccount instanceof CurrentAccount) {
                        bankAccount.applyMonthlyFee();
                    } else {
                        System.out.println("This operation is not supported for this account type.");
                    }
                    break;
                case 5:
                    if (bankAccount instanceof CurrentAccount) {
                        System.out.println("Monthly Fee: " + CurrentAccount.MONTHLY_FEE);
                    } else {
                        System.out.println("This operation is not supported for this account type.");
                    }
                    break;
                case 6:
                    if (bankAccount instanceof SavingsAccount) {
                        bankAccount.applyInterest();
                    } else {
                        System.out.println("This operation is not supported for this account type.");
                    }
                    break;
                case 7:
                    if (bankAccount instanceof SavingsAccount) {
                        System.out.println("Interest Rate: " + SavingsAccount.INTEREST_RATE);
                    } else {
                        System.out.println("This operation is not supported for this account type.");
                    }
                    break;
                case 8:
                    System.out.println("Exiting the system");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
	}

	private void getBalance(int userId) {
		double balance = bankAccount.getBalance(userId);
		System.out.println("Your balance is: " + balance);
	}

	private void deposit(double amount) {
		double newBalance = bankAccount.deposit(amount);
		System.out.println("New balance after deposit: " + newBalance);
	}

	private void withdraw(double amount) {
        double newBalance = bankAccount.withdraw(amount);
        System.out.println("New balance after withdrawal: " + newBalance);
    }

	private void registerUser() {
		System.out.println("Enter the user details");

		System.out.println("Enter User ID: ");
		int userId = sc.nextInt();

		System.out.println("Enter User Name: ");
		String userName = sc.next();

		System.out.println("Enter Password: ");
		String password = sc.next();

		System.out.println("Enter Account Number: ");
		String accountNumber = sc.next();

		System.out.println("Enter Account Type (1 for Current, 2 for Savings): ");
		int accountType = sc.nextInt();

		String accountTypeStr = accountType == 1 ? "Current" : "Savings";

		User u = new User(userId, userName, password, accountNumber, accountTypeStr);
		userList.add(u);

		System.out.println("User registered successfully!");
		bankingMenu();
	}

	private void loginUser() {
		System.out.println("Enter your login credentials: ");
		System.out.println("User name: ");
		String uName = sc.next();
		System.out.println("Password: ");
		String pWord = sc.next();
		int uId = -1;

		for (User u : userList) {
			if (uName.equals(u.getUserName()) && pWord.equals(u.getUserPassword())) {
				System.out.println("Logged in successfully");
				uId = u.getUserId();

				// Instantiate the correct account type
				if ("Current".equals(u.getAccountType())) {
					bankAccount = new CurrentAccount();
				} else if ("Savings".equals(u.getAccountType())) {
					bankAccount = new SavingsAccount();
				}

				break;
			}
		}

		if (uId != -1) {
			bankingOptions(uId);
		} else {
			System.out.println("Invalid credentials. Please try again.");
			bankingMenu();
		}
	}
}
