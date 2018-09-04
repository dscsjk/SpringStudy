package day0413;

public class TestHuman {

	public void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestCalculator tCal = new TestCalculator();
		int iSiNum1 = tCal.iSiNum;
		
		System.out.println(iSiNum1);
		System.out.println( TestCalculator.addNum(iSiNum1) );
	}
}
