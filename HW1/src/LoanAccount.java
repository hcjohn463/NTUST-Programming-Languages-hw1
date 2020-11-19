public class LoanAccount extends SavingAccount 
{

	public LoanAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "LoanAccount";
		interestRate = 0.48;
	}
    
}