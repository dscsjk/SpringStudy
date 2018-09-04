package day0418.exam.kumho;

public class BigWidthTire {

	private String tireName;
	private int size;
	
	public BigWidthTire(){
		tireName = "광폭타이어";
		size = 100;
		System.out.println("BigTire가 생성되었어요.");
	};
	
	public void setTire() {
		System.out.println("BigTire "+tireName+","+size+"가 장착되었어요.");	
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
