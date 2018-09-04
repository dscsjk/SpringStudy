package day0412;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte a = 10, b=20;
		int c = a+b;
		
		char ch ='A'+2;
		
		float f = 3/2F;
		long l = 3000*3000*3000l;
		
		float f2 = 0.1f;
		double d = 0.1f;
		
		boolean result = d==f2;
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
		/*
		int i=0;
		while (i<=10) {
			
			int j=0;
			while ( j<=i) {
				System.out.println("*");
				j++;
			}
			System.out.println();
			i++;
			
		}
		
		*/

			int year = 35;
			System.out.println(year%400==0 );
			
		System.out.println( year%400==0 || ( year%4==0 && year%100!=0) ? "true" : "false");
		
		int[] arr= new int[3];

		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		
		for( int i=0 ; i<answer.length ; i++ ) {
			System.out.printf( "%d", answer[i]);
			for( int j=0; j< answer[i];j++)
				System.out.printf("*");
			
			System.out.println();
		}

	}

}
