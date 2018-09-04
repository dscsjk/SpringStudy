package day0502;

import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) {
		
		byte[] upper = new byte[26];
		byte[] lower = new byte[26];
		
		for(byte i=0; i<upper.length; i++) 
			upper[i]=(byte)(i+'A');
		
		for(byte i=0; i<lower.length; i++) 
			lower[i]=(byte)(i+'a');
			
		String strUpper1="", strLower1=""; 	
		String strUpper = new String(upper);
		strUpper1 += Character.toString(strUpper.charAt(strUpper.indexOf("J")))
									  + strUpper.charAt(strUpper.indexOf("I"))
									  + strUpper.charAt(strUpper.indexOf("N"));

		String strLower = new String(lower);
		strLower1 += Character.toString(strLower.charAt(strLower.indexOf("j")))
									  + strLower.charAt(strLower.indexOf("i"))
									  + strLower.charAt(strLower.indexOf("n"));

		System.out.println("대문자 이름:"+strUpper1);
		System.out.println("소문자 이름:"+strLower1);

		try {
			byte[] bytes1 = strUpper.getBytes("EUC-KR");
			for(int i=0; i<bytes1.length; i++) System.out.print(bytes1[i]);
			System.out.println();
			String str1 = new String(bytes1,"EUC-KR");
			System.out.println(str1);

			byte[] bytes2 = strUpper.getBytes("UTF-8");
			for(int i=0; i<bytes2.length; i++) System.out.print(bytes2[i]);
			System.out.println();
			String str2 = new String(bytes2,"UTF-8");
			System.out.println(str2);
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		
		String oldStr = "자바 프로그래밍 자바 자바";
		String newStr = oldStr.replaceAll("자바.", "JAVA");
		System.out.println(newStr);
		
		StringBuilder sb = new StringBuilder();
		sb.append("Java ");
	}
}
