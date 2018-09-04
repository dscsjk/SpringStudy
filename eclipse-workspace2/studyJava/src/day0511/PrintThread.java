package day0511;

public class PrintThread extends Thread{
	public void run(){
		try {
			while(true) {
				System.out.println("실행 중");
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println("쓰레드가 Sleep중");
		}
		System.out.println("실행종료");
	}
}
