package day0502;

import java.util.StringTokenizer;

public class homework0502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "안녕하세요.자바 힘드시죠.힘내세요~";
		String str2 = "";
		int std=0, end=0;
		for(int i=0;i<str1.length();i++) {
			if (str1.charAt(i) =='.') {
				end = i;
				if (std != end) {
					System.out.println(str1.substring(std, end));
				}
				std = end+1;
			}
		}
		System.out.println(str1.substring(std, str1.length()));

		int i=10;
		double d =20.0;
		str1=String.valueOf(i);
		str2=String.valueOf(d);
		System.out.println(str1+str2);
		int sum;
		sum= Integer.parseInt(str1)+(int)(Double.parseDouble(str2));
		System.out.println(sum);
		
		str1="cat,dog,rabbit,cow";
		str2="";
		String[] names = str1.split(",");
		for(String name :names)
			str2+="["+name+"]";
		System.out.println(str2);

		// StringBuffer 문제
		// 알파벳 생성
		StringBuffer sb = new StringBuffer();
		for (int k='A'; k<='Z';k++) 
			sb.append((char)(k));
		System.out.println("문자열 생성		: "+sb);
		
		// 문자열 끝에 추가
		sb.append("+ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		System.out.println("문자열 추가		: "+sb);
		
		// M과 N사이에 공백 추가
		for(int j=0, indx=-1 ;indx != sb.lastIndexOf("M");) {
			indx= sb.indexOf("M",j);
			if (indx != -1) {
				sb.insert(indx+1, " ");
				j+=indx+1;
			}
		}
		System.out.println("M과 N 사이에 공백 추가	: "+sb);
		
		String ABC= "ABC";
		// 마지막 ABC 문자열 삭제
		sb.delete(sb.lastIndexOf(ABC), sb.lastIndexOf(ABC)+ABC.length());
		System.out.println("ABC문자열 삭제	: "+sb);
		// 문자열 +를 *로 대체
		sb.replace(sb.lastIndexOf("+"), sb.lastIndexOf("+")+1, "*");
		System.out.println("+문자열 *로 대체	: "+sb);
		System.out.println("총길이: "+sb.length());
		
		str1="1,김천재,100,100,100|2,박수재,95,80,90|3,이자바,80,90,90";
		StringTokenizer st1 = new StringTokenizer(str1,"|");
		
		// String Token
		while(st1.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st1.nextToken(),",");
			while(st2.hasMoreTokens()) {
				System.out.println(st2.nextToken());
			}
			System.out.println("----------------");
		}
	}
	
}
