package day0511;

public class ProducerThread extends Thread{
	private DataBox dataBox = new DataBox();

	public ProducerThread(DataBox dataBox){
		this.dataBox = dataBox;
	}
	
	public void run() {
		for(int i=0;i<3;i++) {
			dataBox.SetData("사과 "+i);
		}
	}
}
