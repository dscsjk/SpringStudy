package day0409;

import java.io.*;

public class Test10 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int iEngNum  = 0; 
		int iMathNum = 0;
		boolean run = true;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("영어점수 입력하세요 :");
		System.out.println("--------------------------");
		
		iEngNum = Integer.parseInt(in.readLine());
		
		System.out.println("수학점수 입력하세요 :");
		System.out.println("--------------------------");

		iMathNum = Integer.parseInt(in.readLine());
		
		
		if ( iEngNum <= 60 | iMathNum <= 60 ) {
			System.out.println("5.과락");
		} else if ((iEngNum+iMathNum)/2 >= 70) {
			if ( iEngNum == 100 & iMathNum == 100) {
			    System.out.println("1.합격과 VIP상금 획득");
			} else if ( iEngNum == 100 | iMathNum == 100 ) {
				System.out.println("2.합격과 VIP상장 획득");
			} else {
				System.out.println("3.합격");
			}			
		} else {
			System.out.println("4.불합격");
			
		}
		
	}

}
