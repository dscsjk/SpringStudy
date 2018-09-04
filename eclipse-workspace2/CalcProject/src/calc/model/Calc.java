package calc.model;

public class Calc {
	
	public int cal( int n1, int n2, String op ) {
		int result=0;
		if(op.equals("+")) {
			result = n1+n2;
		} else if(op.equals("-")) {
			result = n1-n2;
		} else if(op.equals("*")) {
			result = n1*n2;
		} else if(op.equals("/")) {
			result = n1/n2;
		}
		return result;
	}
}
