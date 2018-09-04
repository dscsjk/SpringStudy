package day0511;

public class InterruptExample {

	public static void main(String[] args) {

		PrintThread printThread = new PrintThread();
		
		printThread.start();
		
		try {
			Thread.currentThread().interrupt();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("main Sleep");
		}
		
		printThread.interrupt();
	}

}
