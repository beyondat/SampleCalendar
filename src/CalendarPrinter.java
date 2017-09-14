import java.util.Calendar;

public class CalendarPrinter {
	private Calendar cal = Calendar.getInstance();
	private String[] calHead = {"일","월","화","수","목","금","토"};
	private String[][] calAllDate = new String[6][7];
	
	private int calWidth = calHead.length;
	private int calHeight = -1;
	private int startDay; // 시작 요일
	private int lastDay;
	private int input = 1;

	// constructure
	public CalendarPrinter(int year, int month) throws Exception{
		if(month<1 || month>12) {
			throw new Exception();
		} else {
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month-1); //Calendar 내부에서 month의 시작이 0인가봄.
			cal.set(Calendar.DATE, 1);
			startDay = cal.get(Calendar.DAY_OF_WEEK);
			lastDay = cal.getActualMaximum(Calendar.DATE);
			
			System.out.println("year : " + Integer.toString(year));
			System.out.println("month : " + Integer.toString(month));
			System.out.println("StartDay : " + Integer.toString(startDay));
			System.out.println("lastDay : " + Integer.toString(lastDay));
			
			int row=0;
			for(int i=1; input <= lastDay; i++) {
				if(i < startDay)
					calAllDate[row][i-1]=" ";
				else {
					calAllDate[row][(i-1)%calWidth] = Integer.toString(input++);
					if(i%calWidth==0)
						row++;
				}
			}
			calHeight = row;
		}
	}
	
	public void ShowCalendar() {
		for(int i = 0; i<calWidth;i++) {
			System.out.print(calHead[i] + "      ");
		}
		System.out.println();
		
		for(int i = 0; i < calHeight; i++) {
			for(int j = 0; j < calWidth; j++) {
				//System.out.print(Integer.toString(j+(7*i)) + " ");
				System.out.print(calAllDate[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
}