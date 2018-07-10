package s03b;

public class Calculator {

	public void addition(int firstNum, int secondNum) {
		System.out.println("더하기");
		int result = firstNum + secondNum;
		System.out.println(result);
	}
	
	public void subtraction(int firstNum, int secondNum) {
		System.out.println("빼기");
		int result = firstNum - secondNum;
		System.out.println(result);
	}
	public void multiplication(int firstNum, int secondNum) {
		System.out.println("곱하기");
		int result = firstNum * secondNum;
		System.out.println(result);
	}
	public void division(int firstNum, int secondNum) {
		System.out.println("나누기");
		int result = firstNum / secondNum;
		System.out.println(result);
	}
	
}
