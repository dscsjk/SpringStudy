package day0410;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		for ( int m=1; m<10 ; m++ ) {
			
			System.out.println( "***** "+m+"단  *****" );
			
			for ( int n=1; n<10 ; n++ ) {
				System.out.println( m + "x" + n + "=" + (m*n) );
			}
		}
	}
}
