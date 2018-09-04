package day0410;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		//String sNumber = "";
		//score = (char)System.in.read();
		BufferedReader bfInStr = new BufferedReader(new InputStreamReader(System.in));
		
		//sNumber = in.readLine();
		
		//System.out.println(sNumber);

		
		switch( bfInStr.readLine() ) {
			case "AA" :
				System.out.println( "우수회원");
				break;
			case "BB" :
				System.out.println( "열심회원");
				break;
			case "CC" :
				System.out.println( "일반회원");
				break;
			case "DD" :
				System.out.println( "새내기회원");
				break;
			default :
				System.out.println( "회원이 아닙니다.");
				break;
		}
	}

}
