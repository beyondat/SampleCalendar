
import java.util.Scanner;

public class CalendarMain {
	public static void main(String[] args) {
		int year;
		int month;
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the year what you want");
		year = sc.nextInt();
		System.out.println("Enter you wanna month");
		month = sc.nextInt();
		
		try {
			CalendarPrinter cp = new CalendarPrinter(year, month);
			cp.ShowCalendar();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
