package day0416;

public class HomeworkClass {
	String clsNm;
	int clsId;
	
	HomeworkClass() {
		clsNm = "홍길동";
		clsId = 0;
	}
	
	HomeworkClass(String clsNm) {
		System.out.println(clsNm);
		setClass(clsNm);
		
	}

	void setClass(String clsNm) {
		System.out.println("변수 초기화");
		this.clsNm = clsNm;
		this.clsId = 0;
		printClass();
	}

	void printClass() {
	System.out.println("변수 출력");
	System.out.println(clsNm);
	System.out.println(clsId);
	}
	
}
