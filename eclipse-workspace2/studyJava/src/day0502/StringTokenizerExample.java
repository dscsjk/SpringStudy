package day0502;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {

		String fruits1 = "사과-배-감-귤-딸기-망고-수박-체리-참외-오렌지";
		
		StringTokenizer st = new StringTokenizer(fruits1,"-");
		
		String[] fruits2 = new String[st.countTokens()];
		int i;
		for( i =0; i<st.countTokens(); i++) {
			fruits2[i]= st.nextToken();
			System.out.println(fruits2[i]);
		}
		
		System.out.println();
		while(st.hasMoreTokens()) {
			fruits2[i]= st.nextToken();
			System.out.println(fruits2[i]);
			i++;
		}
	}
}
