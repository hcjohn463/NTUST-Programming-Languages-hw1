/*
 *  Derived class: LoanAccount
 *
 *  Description:
 *     like a saving account, but the balance is "negative" (you owe
 *     the bank money, so a deposit will reduce the amount of the loan);
 *     you can't withdraw (i.e., loan more money) but of course you can
 *     deposit (i.e., pay off part of the loan).
*/

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LoanAccount extends SavingAccount 
{
	public LoanAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "LoanAccount";
		interestRate = 0.48;
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
		System.out.println("Withdraw $" + withdrawMoney + " !");
		System.out.println("Checking");
		System.out.println("Can't withdraw!");
		return accountBalance;
	}
	public double computeInterest(LocalDate interestDate) {
		lastAccessDate = interestDate;
		System.out.println("Compute interest!");
		System.out.println("Checking");
		long differenceMonths = ChronoUnit.MONTHS.between(lastInterestDate,interestDate);
		System.out.println("Number of days since last interest is " + differenceMonths);
		double interestEarned = accountBalance * (interestRate / 365) * differenceMonths;
		accountBalance += interestEarned;
		System.out.println("Interest earned: $" + interestEarned);
		lastInterestDate = interestDate;
		return accountBalance;
	}
}