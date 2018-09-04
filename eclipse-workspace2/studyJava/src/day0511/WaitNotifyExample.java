package day0511;

public class WaitNotifyExample {

	public static void main(String[] args) {

		DataBox dataBox = new DataBox();
		
		ProducerThread producerThread =  new ProducerThread(dataBox);
		ConsumerThread comsumerThread =  new ConsumerThread(dataBox);
		ProducerThread producerThread1 =  new ProducerThread(dataBox);
		ConsumerThread comsumerThread1 =  new ConsumerThread(dataBox);
		
		producerThread.start();
		comsumerThread.start();
		producerThread1.start();
		comsumerThread1.start();
		
	}

}
