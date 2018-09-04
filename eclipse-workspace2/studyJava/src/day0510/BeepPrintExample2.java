package day0510;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) {
		// 1번
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch (Exception e){};
		}
		
		// 2번 익명
		Thread thread1 = new Thread(new BeepTask()) {
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0;i<5;i++) {
					toolkit.beep();
					try { Thread.sleep(500); } catch (Exception e){}
				}
			}
		};
		
		// 3번 람다식
		Thread thread2 = new Thread(()-> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for(int i=0;i<5;i++) {
				toolkit.beep();
				try { Thread.sleep(500); } catch (Exception e){}
			}
		});
	}
}
