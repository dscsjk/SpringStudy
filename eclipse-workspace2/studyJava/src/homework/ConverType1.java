package homework;

public class ConverType1 {

	public static void main(String[] args) {
		
		// double을 int로 변경
		double dVal1 = 123.456789;
		System.out.println("dVal1 : [" + dVal1 + "]");
		int iVal1 = (int)dVal1;
		System.out.println("dVal1->int로 변경 : [" + iVal1 + "]");

		// int를 double로 변경
		iVal1 = 456;
		System.out.println("iVal1 : [" + iVal1 + "]");
		dVal1 = (double)iVal1;
		System.out.println("iVal1->double로 변경 : [" + dVal1 + "]");
		
		// char를 int로 변경
		char cVal1 = '앗';
		System.out.println("cVal1 : [" + cVal1 + "]");
		int iVal2 = (int) cVal1;
		System.out.println("cVal1->int로 변경 : [" + iVal2 + "]");
		
	}

}
