package day0410;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int score = 0;
		//score = (char)System.in.read();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		score = Integer.parseInt(in.readLine());
		
//		System.out.println(score);
		
		String grade = "";
		if ( score >= 90 ) {
			if (score >= 95) grade = "A+";
			else grade = "A";
		} else 
			if (score >= 85) grade = "B+";
			else grade = "B";
			{
		}

		System.out.println("score=" + score);
		System.out.println("grade=" + grade);
}
}