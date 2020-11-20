import java.time.LocalDate;
public class Account
{
	protected String accountName;
	protected String accountType;
	protected LocalDate openDate;
	protected LocalDate lastAccessDate;
	protected LocalDate lastInterestDate;
	protected double interestRate;
	protected double accountBalance;
	
	public Account(String name, double balance) {
		this.accountName = name;
		this.accountBalance = balance;
	}
	
	public String getName() {
		return accountName;
	}
	public String getType() {
		return accountType;
	}
	public LocalDate getLastAccessDate() {
		return lastAccessDate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public double getBalance() {
		return accountBalance;
	}
	
	public double deposit(double depositMoney, LocalDate depositDate) {
		return (deposit(depositMoney, depositDate));
	}
	
	public double withdraw(double withdrawMoney,LocalDate withdrawDate) {
		return(withdraw(withdrawMoney, withdrawDate));
	}
	public double computeInterest(LocalDate interestDate) {
		return(computeInterest(interestDate));
	}
}