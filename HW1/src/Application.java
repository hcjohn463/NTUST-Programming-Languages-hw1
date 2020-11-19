public class Application 
{    
    public static void main(String args []) 
    {
    	//Setting Account Information
    	//2 parameters: name, initial money
    	Account[] accountList = new Account[4];
        accountList[0] = new CheckingAccount("Chloe", 3000);
        accountList[1] = new SavingAccount("Sam", 4000);
        accountList[2] = new CDAccount("Cris", 5000);
        accountList[3] = new LoanAccount("Louis", -2000);
        
        //Test
        for(int i = 1 ; i < 2 ; i++)
        {
        	//Begin
        	System.out.println("=======Account" + (i + 1) + "========");
        	System.out.println("Account Name: "  + accountList[i].getName());
        	System.out.println("Account Type: "  + accountList[i].getType());
        	System.out.println("Account Interest: "  + accountList[i].getInterestRate());
        	System.out.println("Account Balance: "  + accountList[i].getBalance() + "\n");
        	
        	//after 2 days
        	System.out.println("After 2 days: ");
        	System.out.println("Compute interest. Balance: " + accountList[i].computeInterest(2) + "\n");
        	
        	//after 60 days(2 months)
        	System.out.println("After 60 days (2 months):");
        	System.out.println("Compute interest. Balance: " + accountList[i].computeInterest(60) + "\n");
        	
//        	
//        	//Setting time
//        	int remainDay = 2;
//        	accountList[i].deposit(testMoney);
        	
        }
    }
}          