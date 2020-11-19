public class CheckingAccount extends Account
{
	
	public CheckingAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "CheckingAccount";
		interestRate = 0.12;
	}
	public void withdraw(double withdrawMoney,int days) {
		System.out.println("Checking");
		System.out.println("Withdraw money: " + withdrawMoney + "\n");
		accountBalance -= withdrawMoney;
	}
	public double computeInterest(int days) {
		double interestEarned = accountBalance * (interestRate / 365) * days;
		accountBalance += interestEarned;
		System.out.println("Compute interest: " + interestEarned);
		return accountBalance;
	}
}