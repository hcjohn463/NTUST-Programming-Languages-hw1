import java.time.LocalDate;  
public class Application 
{    
    public static void main(String args []) 
    {
    	//Setting Account Information
    	//2 parameters: name, initial money
    	Account[] accountList = new Account[4];
        accountList[0] = new CheckingAccount("Chloe", 1500);
        accountList[1] = new SavingAccount("Sam", 1200);
        accountList[2] = new CDAccount("Cris", 1000);
        accountList[3] = new LoanAccount("Louis", -1500);
        
        //Test
        for(int i = 0 ; i < accountList.length ; i++)
        {
        	//Begin
        	LocalDate nowDate;
        	System.out.println("=======Account" + (i + 1) + "========");
        	System.out.println("Account Name: "  + accountList[i].getName());
        	System.out.println("Account Type: "  + accountList[i].getType());
        	System.out.println("Account Open Date: "  + accountList[i].getLastAccessDate());
        	System.out.println("Account Interest: "  + accountList[i].getInterestRate());
        	System.out.println("Account Balance: $"  + accountList[i].getBalance() + "\n");
        	
        	//after 2 days, Compute interest!
        	System.out.println("After 2 days: ");
        	nowDate = nextDays(accountList[i].lastAccessDate,2);
        	System.out.println("Now Date: " + nowDate);
        	System.out.println("Balance: $" + accountList[i].computeInterest(nowDate) + "\n");
        	
        	//after 2 months, Compute interest!
        	System.out.println("After 2 months: ");
        	nowDate = nextMonths(accountList[i].lastAccessDate,2);
        	System.out.println("Now Date: " + nowDate);
        	System.out.println("Balance: $" + accountList[i].computeInterest(nowDate) + "\n");
        	
        	//after 1 day, Deposit 100!
        	System.out.println("After 1 days: ");
        	nowDate = nextDays(accountList[i].lastAccessDate,1);
        	System.out.println("Now Date: " + nowDate);
        	System.out.println("Balance: $" + accountList[i].deposit(100,nowDate) + "\n");
        	
        	//after 1 day, Withdraw 100!
        	System.out.println("After 1 days: ");
        	nowDate = nextDays(accountList[i].lastAccessDate,1);
        	System.out.println("Now Date: " + nowDate);
        	System.out.println("Balance: $" + accountList[i].withdraw(100,nowDate) + "\n");
        	
        	//after 1 day, Deposit 500! 
        	System.out.println("After 1 days: ");
        	nowDate = nextDays(accountList[i].lastAccessDate,1);
        	System.out.println("Now Date: " + nowDate);
        	System.out.println("Balance: $" + accountList[i].deposit(500,nowDate) + "\n");
        	
        	//after 1 day, Withdraw 500!
        	System.out.println("After 1 days: ");
        	nowDate = nextDays(accountList[i].lastAccessDate,1);
        	System.out.println("Now Date: " + nowDate);
        	System.out.println("Balance: $" + accountList[i].withdraw(500,nowDate) + "\n");
        	
        	//after 1 day, Withdraw 5000!
        	System.out.println("After 1 days: ");
        	nowDate = nextDays(accountList[i].lastAccessDate,1);
        	System.out.println("Now Date: " + nowDate);
        	System.out.println("Balance: $" + accountList[i].withdraw(5000,nowDate) + "\n");
        }
    }
    static LocalDate nextDays(LocalDate nowDate, int days) {
    	LocalDate newDate = nowDate.plusDays(days);
	    return newDate;
    }
    
    static LocalDate nextMonths(LocalDate nowDate, int months) {
    	LocalDate newDate = nowDate.plusMonths(months);
	    return newDate;
    }
}          