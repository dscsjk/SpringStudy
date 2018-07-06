package s02;

public class Calculator {

	private int firstNum;
	private int secondNum;
	
	public void addition() {
		System.out.println("더하기");
		int result = firstNum + secondNum;
		System.out.println(result);
	}
	
	public void subtraction() {
		System.out.println("빼기");
		int result = firstNum - secondNum;
		System.out.println(result);
	}
	public void multiplication() {
		System.out.println("곱하기");
		int result = firstNum * secondNum;
		System.out.println(result);
	}
	public void division() {
		System.out.println("나누기");
		int result = firstNum / secondNum;
		System.out.println(result);
	}
	
	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
}
