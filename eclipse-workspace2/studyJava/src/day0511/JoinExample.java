package day0511;

public class JoinExample {

	public static void main(String[] args) {

		SumThread sumThread = new SumThread();
		
		sumThread.start();
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100의 합 "+sumThread.getSum());
	}

}
