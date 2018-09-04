package day0409;

public class CalcType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float dValue = 0.012F ;

		
		System.out.println("result1=["+ -dValue +"]");
		
		System.out.println("result2=["+ dValue +"]");
		
		
		short s = 100;
		
		int is = -s;
		System.out.println("result=["+ is +"]");
		
		System.out.println("result=["+ -is +"]");
		System.out.println("result=["+ +is +"]");
		
		System.out.println("result=["+ is +"]");

		
		boolean play = true;
		System.out.println(play);
		play = !play;
		System.out.println(play);
		play = !play;
		System.out.println(play);

	}

}
