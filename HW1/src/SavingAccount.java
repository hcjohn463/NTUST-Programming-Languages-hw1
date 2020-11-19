public class SavingAccount extends Account 
{
	public SavingAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "SavingAccount";
		interestRate = 0.24;
	}
	public double computeInterest(int days) {
		double interestEarned;
		if(days < 30) {
			interestEarned = 0.0;
		}
		else {
			interestEarned = accountBalance * (interestRate / 12) * (days / 30);
		}
		accountBalance += interestEarned;
		System.out.println("Compute interest: " + interestEarned);
		return accountBalance;
	}
}