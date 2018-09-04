package day0511;

public class DataBox {
	private String data;
	
	public synchronized String GetData() {
		if (data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		String returnValue = data;
		System.out.println("ConsumerThread가 읽은 데이터: "+returnValue+" : "+Thread.currentThread().getName());
		data=null;
		notify();
		
		return returnValue;
	}

	public synchronized void SetData(String data) {
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.data = data;
		System.out.println("ProducerThread가 생성한 데이터: "+data+" : "+Thread.currentThread().getName());
		notify();
	}
}
