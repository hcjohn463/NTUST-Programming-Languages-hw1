/*
 *  Derived class: CheckingAccount
 *
 *  Description:
 *      Interest is computed daily; there's no fee for
 *      withdraw; there is a minimum balance of $1000.
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CheckingAccount extends Account
{
	
	public CheckingAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "CheckingAccount";
		interestRate = 0.12;
		openDate = LocalDate.now();
		lastAccessDate = openDate;
		lastInterestDate = openDate;
	}
	public double deposit(double depositMoney, LocalDate depositDate) {
		lastAccessDate = depositDate;
		System.out.println("Deposit $" + depositMoney + " !");
		System.out.println("Checking");
		System.out.println("Deposit money: $" + depositMoney);
		accountBalance += depositMoney;
		return accountBalance;
	}
	public double withdraw(double withdrawMoney,LocalDate withdrawDate) {
		lastAccessDate = withdrawDate;
		System.out.println("Withdraw $" + withdrawMoney + " !");
		System.out.println("Checking");
		if((accountBalance - withdrawMoney) < 1000) {
			System.out.println("Can't withdraw!");
		}
		else {
			System.out.println("Withdraw money: $" + withdrawMoney);
			accountBalance -= withdrawMoney;
		}
		return accountBalance;
	}
	public double computeInterest(LocalDate interestDate) {
		lastAccessDate = interestDate;
		System.out.println("Compute interest!");
		System.out.println("Checking");
		long differenceDays = ChronoUnit.DAYS.between(lastInterestDate,interestDate);
		System.out.println("Number of days since last interest is " + differenceDays);
		double interestEarned = accountBalance * (interestRate / 365) * differenceDays;
		accountBalance += interestEarned;
		System.out.println("Interest earned: $" + interestEarned);
		lastInterestDate = interestDate;
		return accountBalance;
	}
}