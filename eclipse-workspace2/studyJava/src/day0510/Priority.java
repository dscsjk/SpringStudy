package day0510;

public class Priority {

	public static void main(String[] args) {
		for(int i =0 ; i<11;i++) {
			Thread thread = new CalcThread("thread"+i);
			if (i!=10) {
				thread.setPriority(thread.MIN_PRIORITY);
			} else {
				thread.setPriority(thread.MAX_PRIORITY);
			}
			thread.start();
		}

	}

}
