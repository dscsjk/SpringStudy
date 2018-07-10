package s03;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		
		myCalculator.setFirstNum(15);
		myCalculator.setSecondNum(7);
		
		myCalculator.add();
		myCalculator.sub();;
		myCalculator.mul();;
		myCalculator.div();
 
	}

}
