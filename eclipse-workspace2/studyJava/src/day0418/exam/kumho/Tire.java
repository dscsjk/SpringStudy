package day0418.exam.kumho;

public class Tire {
	private String tireName;
	private int size;
	
	public Tire(){
		tireName = "금호타이어";
		size = 80;
		System.out.println("금호Tire가 생성되었어요.");
	};
	
	public void setTire() {
		System.out.println("Tire "+tireName+","+size+"가 장착되었어요.");	
	}
	public String getTireName() {
		return tireName;
	}
	void setTireName(String tireName) {
		this.tireName = tireName;
	}
	public int getSize() {
		return size;
	}
	void setSize(int size) {
		this.size = size;
	}
}
