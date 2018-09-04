package stringExample;

/**
 * @author 
 * @김수정 : user
 * @날짜  : 2018. 4. 5.  
 * @파일명 : StringExample.java
 */

public class StringExample {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			char c1 = 'A';		// 문자를 직접
			char c2 = 65; 		// 10진수의 유니코드 값을 직접
			char c3 = '\u0041'; //16진수 유니코드값 직접
			
			char c4 = '가';
			char c5 = 44032;
			char c6 = '\uac00';
			
			char c7 = 120;
			
			int uniCode = c4;
			
			String strName= "가나";
			
					
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3);
			System.out.println(c4);
			System.out.println(c5);
			System.out.println(c6);
			System.out.println("테스트: " + c7);
			System.out.println("int로 유니코드추출: " + uniCode);
			
			System.out.println("스트링추출 : " + strName);
			
			
	}

}
