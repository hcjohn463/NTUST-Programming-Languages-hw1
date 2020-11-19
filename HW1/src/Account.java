public class Account
{
	public String accountName;
	public String accountType;
	public double interestRate;
	public double accountBalance;
	
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
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public double getBalance() {
		return accountBalance;
	}
	
	public void deposit(double depositMoney) {
		System.out.println("Deposit money: " + depositMoney + "\n");
		accountBalance += depositMoney;
	}
	
	public void withdraw(double withdrawMoney) {
		System.out.println("Withdraw money: " + withdrawMoney + "\n");
		accountBalance -= withdrawMoney;
	}
	public double computeInterest(int days) {
		System.out.println("Account Balance: " + accountBalance);
		return accountBalance;
	}
}