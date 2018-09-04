package day0410;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = (int)(Math.random()*45)+1;
		System.out.println(score);
		
		
		if ( score == 40 ) {
			System.out.println("금1돈");
			System.out.println("A");
			
		} else if (score == 20) {
			System.out.println("은1돈");
			System.out.println("B");
		} else if (score == 10) {
			System.out.println("상품권지급");
			System.out.println("C");
		} else {
			System.out.println("꽝입니다.");
			System.out.println("F");
		}
	
	}

}
