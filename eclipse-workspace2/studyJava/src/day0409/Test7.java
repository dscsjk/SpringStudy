package day0409;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVar1 = "김수정";
		String strVar2 = "김수정";
		String strVar3 = new String("김수정");
		
		System.out.println( strVar1 == strVar2); // 주소비교 
		System.out.println( strVar1 == strVar3);
		System.out.println( strVar1.equals(strVar2));
		System.out.println( strVar1.equals(strVar3)); 
		
		
	}

}
