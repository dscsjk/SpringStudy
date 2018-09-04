package day0511;

public class ConsumerThread extends Thread {
	private DataBox dataBox = new DataBox();

	public ConsumerThread(DataBox dataBox){
		this.dataBox = dataBox;
	}

	public void run() {
		for(int i=0;i<3;i++) {
			String data = dataBox.GetData();
		}
	}
}
