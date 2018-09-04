package day0410;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 85;
		
		char grade = (score > 90 ) ? 'A' : ( (score > 80 ) ? 'B' : 'C' );
		System.out.println(score+" "+grade+"");
		
		String result = (!(score>90))?"가":"나";
		System.out.println(result);
	}

}
