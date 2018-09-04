package day0412;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] sClass;
		sClass = new String[20][2];
		
		outstar( sClass.length );
		
		for ( int i=0; i < sClass.length ; i++ ) { 
			sClass[i][0]="자바"+ (i+1);
			System.out.printf("%s\t", sClass[i][0]);
		
		}
		System.out.println();

		for ( int i=0; i < sClass.length ; i++ ) { 
			int iNum = (int)(Math.random()*101);
			sClass[i][1]= Integer.toString(iNum);
			System.out.printf("%s\t", sClass[i][1]);
		}
		System.out.println();
		outstar(sClass.length);
	}
	
	static void outstar(int ileng) {
		for ( int i=0; i < (ileng*8) ; i++ ) { 
			System.out.printf("%c",'*');
		}
		System.out.println();
	}
}
