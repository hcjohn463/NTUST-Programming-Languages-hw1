package test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();  
	    LocalDate yesterday = date.minusDays(1);  
	    LocalDate tomorrow = yesterday.plusDays(2);  
	    System.out.println("Today date: "+date);  
	    System.out.println("Yesterday date: "+yesterday);  
	    System.out.println("Tommorow date: "+tomorrow);
	    System.out.println(date.isAfter(tomorrow));
	}

}
