package day0411;

//import java.util.Calendar;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Week today = Week.SUNDAY;
		
		String name = today.name();
		System.out.println(name);
		
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		
		System.out.println(result1);
		System.out.println(result2);
		
		if (args.length == 1) {
			
			//String strDay = args[0];
			//Week weekDay = Week.valueOf(strDay);
			
			Week weekDay = Week.valueOf(args[0]);
			
			if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY ) {
				System.out.println("주말이군요");
				
			} else {
				System.out.println("평일이군요");
				
			}
			
		}
		
		Week[] days = Week.values();
		for (Week day : days) {
			System.out.println(day);
		}
		
		System.out.println(days.length);
		
		/*
		for( int i = 0 ;i < days.length; i++ ) {
			System.out.println(days[i]);
		}
		*/
	}

}
