package Exam0406;

public class OperationsPromotionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte bValue1 = 10;
		byte bValue2 = 20;
		byte bValue3 = (byte)(bValue1 + bValue2);  
		// 연산의 경우 결과값의 데이타 타입을 int로 변환한다. 그러나 long이 연산에 포함되면 long으로 바뀜
		// double 도 마찬가지임
		int iValue1 = bValue1 + bValue2;
		
		System.out.println(iValue1);
		
		char cValue1 = 'A';
		char cValue2 = 1;
		char cValue3 = (char)(cValue1 + cValue2);
		int iValue2 = cValue1 + cValue2;
		System.out.println(iValue2);
		System.out.println((char)iValue2);

		
		int iValue3 = 10;		
		int iValue4 = iValue3 / 4;		
		System.out.println(iValue4);
				
		
		byte byteValue = 10;
		char charValue = 'A';
		//short shortValue = charValue;
		
		String strValue = "";
		
		//char var = (char)strValue;
		
		long var2 = 10000000000L;
		char var3 = 0x00;
		
		System.out.println("char 초기화 [" +var3+"]");
		
		}

}
