package day0426;

public class NumberFormatExcetprionExample {

	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = testMethod(data1);
		int value2 = testMethod(data2);
		int result = value1+value2;
		System.out.println(value1+"+"+value2+"="+result);
		
	}

	public static int testMethod (String data) {
		int value=0;
		try {
			value = Integer.parseInt(data);
			System.out.println("1.입력값은-> "+value+" 입니다.");
			
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("2.숫자가 아닙니다. 다시 입력하세요.");
		} finally {
		}
		return value;
	}
}
