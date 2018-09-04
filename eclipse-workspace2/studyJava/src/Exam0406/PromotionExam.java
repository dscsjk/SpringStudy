package Exam0406;

public class PromotionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// byte < short < int < long < float < double
		
		byte byteV = 5;		int intV;
		intV = byteV+200;
		System.out.println(intV);

		char charV = 'Z'; int intV2;
		intV2=charV;
		System.out.println(intV2);
		
		charV= (char)intV2;
		double doubleV = 3.14325; byte byteV2;
		byteV2=(byte)doubleV;
		System.out.println(byteV2);

		long longV = 314325; float floatV=314.325F;
		longV = (long)floatV;
		System.out.println(longV);
		
		int intValue = 44032;
		char charValue = (char)intValue;
		System.out.println(charValue);
		
		long longValue = 500000000;
		intValue = (int)longValue;
		System.out.println(intValue);
		
		intValue = (int)doubleV;
		System.out.println(intValue);
		
		
		int num1 = 123456780;
		int num2 = 123456780;
		
		double num3 = num2;
		num2 = (int) num3;
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		int result = num1 - num2;
		System.out.println("result : " + result);
		
		int a,b ,c ,d;
		a = b = c = d = 0;
		
		System.out.println(a+b+c+d);
		
		
		
	}

}
