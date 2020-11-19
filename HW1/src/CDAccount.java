public class CDAccount extends Account 
{

	public CDAccount(String name, double balance) {
		super(name, balance);
		// TODO Auto-generated constructor stub
		accountType = "CDAccount";
		interestRate = 0.36;
	}
     
}