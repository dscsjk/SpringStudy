
package day0409;

public class Test6 {
	public static void main(String[] args) {
		int apple  =1;
		double pieceUnit  = 0.1;
		double number =7;
		
		double result =  apple * ((10-number)/10);
		
		System.out.println(result);
		
		System.out.println("==============");
		
		int x= 1;
		double y = 0.0;
		double z = x/y;
		
		System.out.println(Double.isInfinite(z));
		System.out.println(Double.isNaN(z));
		System.out.println(z+2);
		
		if(Double.isInfinite(z)||Double.isNaN(z))
			System.out.println("값이 무한대이거나 NaN");
		else
			System.out.println(z+2);
		
		
		
		String str1  = "JDK"+6.0;
		String str2  = str1+"_";
		System.out.println(str2);
		
		String str3  = "JDK"+3+3.0;
		String str4  = 3+3.0+"JDK";
		System.out.println(str3);
		System.out.println(str4);
		
		
		
		
}

}
