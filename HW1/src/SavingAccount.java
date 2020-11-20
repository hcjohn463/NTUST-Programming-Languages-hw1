/*
 *  Derived class: SavingAccount
 *
 *  Description:
 *     monthly interest; fee of $1 for every transaction, except
 *     the first three per month are free; no minimum balance.
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SavingAccount extends Account 
{
	public double transactionFee = 1.0;
	public int freeTransactionCount = 3;
	
	public SavingAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "SavingAccount";
		interestRate = 0.24;
		openDate = LocalDate.now();
		lastAccessDate = openDate;
		lastInterestDate = openDate;
	}
	public double deposit(double depositMoney, LocalDate depositDate) {
		lastAccessDate = depositDate;
		System.out.println("Deposit $" + depositMoney + " !");
		System.out.println("Checking");
		if(freeTransactionCount > 0) {
			freeTransactionCount--;
		}
		else {
			System.out.println("Receive a $" +  transactionFee + " fee.");
			accountBalance -= transactionFee;
		}
		System.out.println("Deposit money: $" + depositMoney);
		accountBalance += depositMoney;
		return accountBalance;
	}
	public double withdraw(double withdrawMoney,LocalDate withdrawDate) {
		lastAccessDate = withdrawDate;
		System.out.println("Withdraw $" + withdrawMoney + " !");
		System.out.println("Checking");
		if(freeTransactionCount > 0) {
			freeTransactionCount--;
		}
		else {
			System.out.println("Receive a $" +  transactionFee + " fee.");
			withdrawMoney += transactionFee;
		}
		if((accountBalance - withdrawMoney) < 0) {
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
		long differenceMonths = ChronoUnit.MONTHS.between(lastInterestDate,interestDate);
		double interestEarned = accountBalance * (interestRate / 12) * differenceMonths;
		if(freeTransactionCount > 0) {
			freeTransactionCount--;
		}
		else {
			System.out.println("Receive a $" +  transactionFee + " fee.");
			interestEarned -= transactionFee;
		}
		System.out.println("Number of months since last interest is " + differenceMonths);
		accountBalance += interestEarned;
		System.out.println("Interest earned: $" + interestEarned);
		lastInterestDate = interestDate;
		
		if(differenceMonths > 0) {
			freeTransactionCount = 3;
		}
		
		return accountBalance;
	}
}