package day0511;

public class SumThread extends Thread {
	int sum;
	
	public int getSum() {
		return sum;
	}

	public void run () {
		for(int i=1; i <= 100;i++ ) {
			sum += i;
		}
	}
}
