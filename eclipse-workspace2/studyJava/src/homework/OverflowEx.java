package homework;

public class OverflowEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char  cMin = 5;
		char  cMax = 65531;
		
		System.out.println("char min. value: " + (int)Character.MIN_VALUE);
		System.out.println("char max. value: " + (int)Character.MAX_VALUE);

		System.out.printf("%n");
		System.out.println( "< 1. Char 최대값 위로 Overflow >");
		
		int iMax = (int)cMax;
		
		for ( int i=iMax ; i <= (int)Character.MAX_VALUE+5 ; i++ ) {
			System.out.println( "char value: ["+iMax+"] = [" +  cMax + "]");
			
			if ( iMax == (int)Character.MAX_VALUE ) 
				System.out.println( "========= OverFlow =========");
			     
			cMax++;
			iMax++;
			
		}

		System.out.printf("%n");
		System.out.println( "< 2. Char 최소값 아래로 Overflow >");

		int iMin = (int)cMin;
		
		for ( int i=iMin ; i >= (int)Character.MIN_VALUE-5 ; i-- ) {
			System.out.println( "char value: ["+iMin+"] = [" +  cMin + "]");
			
			if ( iMin == (int)Character.MIN_VALUE ) 
				System.out.println( "========= OverFlow =========");
			     
			cMin--;
			iMin--;
		
		}
		
	}

}
