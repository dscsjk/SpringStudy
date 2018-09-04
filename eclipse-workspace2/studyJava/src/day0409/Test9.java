package day0409;

public class Test9 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int charCode = 'A';
		
		System.out.println("입력하세요 :");
		
		charCode = System.in.read();
		
		if ( (charCode>=65) & (charCode<=90))
			System.out.println("대문자");
		
		if ( (charCode>=97) && (charCode<=122))
			System.out.println("소문자");

		
		System.out.println("===================");
		
		if ( charCode > 48 && (charCode<57)) 
			System.out.println("숫자");
			
		/*
		int value = 6;
		if ( value%2==0 | value%3==0)
			System.out.println("2의배수 또는 3의배수");
		
		if ( value%2==0 || value%3==0)
			System.out.println("2의배수 또는 3의배수");
*/
	}

}
