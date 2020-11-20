/*
 *  Derived class: CDAccount
 *
 *  Description:
 *      monthly interest; fixed amount and duration (e.g., you can open
 *      1 12-month CD for $5000; for the next 12 months you can't deposit
 *      anything and withdrawals cost a  $250 fee); at the end of the 
 *      duration the interest payments stop and you can withdraw w/o fee.
*/

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CDAccount extends Account 
{
	public LocalDate deadline;
	
	public CDAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "CDAccount";
		interestRate = 0.36;
		openDate = LocalDate.now();
		lastAccessDate = openDate;
		lastInterestDate = openDate;
		deadline = openDate.plusYears(1);
	}
	public double deposit(double depositMoney, LocalDate depositDate) {
		lastAccessDate = depositDate;
		System.out.println("Deposit $" + depositMoney + " !");
		System.out.println("Checking");
		if(depositDate.isBefore(deadline)) {
			System.out.println("Can't deposit!");
		}
		else {
			System.out.println("Deposit money: $" + depositMoney);
			accountBalance += depositMoney;
		}
		return accountBalance;
	}
	public double withdraw(double withdrawMoney,LocalDate withdrawDate) {
		lastAccessDate = withdrawDate;
		System.out.println("Withdraw $" + withdrawMoney + " !");
		System.out.println("Checking");
		if(withdrawDate.isBefore(deadline)) {
			withdrawMoney += 250;
			System.out.println("Receive a penalty of $250 fee.");
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
		
		//the interest payments stop 
		if(interestDate.isAfter(deadline)) {
			interestDate = deadline;
		}
		else {
			long differenceMonths = ChronoUnit.MONTHS.between(lastInterestDate,interestDate);
			System.out.println("Number of months since last interest is " + differenceMonths);
			double interestEarned = accountBalance * (interestRate / 12) * differenceMonths;
			accountBalance += interestEarned;
			System.out.println("Interest earned: $" + interestEarned);
			lastInterestDate = interestDate;
		}
		return accountBalance;
	}
}