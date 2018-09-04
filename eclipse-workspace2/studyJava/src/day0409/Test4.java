package day0409;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v1 = 10;
		int v2 = ~v1;
		int v3 = ~v1 + 1;
		
		System.out.println( toBinaryString(v1) + "(v1:" + v1 + ")"); 
		System.out.println( toBinaryString(v2) + "(v2:" + v2 + ")"); 
		System.out.println( toBinaryString(v3) + "(v3:" + v3 + ")"); 
		System.out.println();
	}
	
	public static String toBinaryString(int value) {
		String str = Integer.toBinaryString(value);
		while(str.length() < 32) {
			str = "0" + str;
		}
		return str;
	}

}
