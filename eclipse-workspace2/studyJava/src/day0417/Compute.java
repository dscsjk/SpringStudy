package day0417;

public class Compute {
	
	Compute(){}
	
	public int sumTot(int[] values) {
		
		int sum=0;
				
		for (int i=0;i<values.length;i++)
			sum +=values[i];
		return sum;
	}
	
	public int sumTot1(int ... values) {
		
		int sum=0;
				
		for (int i=0;i<values.length;i++)
			sum +=values[i];
		return sum;
	}
	
}
