package day0412;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outstar( 3 );
		System.out.printf("**********************************\n");
		outstar( 5 );
	}
	
	static void outstar(int iFamCnt) {
		String [][] idNumber = new String [5][iFamCnt];

		for ( int i=0; i < idNumber.length ; i++ ) { 
			for ( int j=0; j < idNumber[i].length ; j++) {
				idNumber[i][j]="방번호"+ Integer.toString((int)(Math.random()*9));
				System.out.printf("[%d][%d]=(%s),	", i,j,idNumber[i][j]);
			}
			System.out.println();
		}
	}
}
