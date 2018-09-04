package day0425.test1;

public class A {
	//인스턴스 필드
	B field1 = new B();
	C field2 = new C();
	
	//인스턴스 메소드
	void method1() {
		B var1 = new B();
		C var2 = new C();
		C.filed5=0;
		
	}

	//정적필드 초기화 
	//클래스A 생성없이 인스턴스 클래스B가 생성되지 않는다. 
	//따라서  static으로  B클래스 field3를 만들 수 없음.
	//static B field3 = new B();
	//클래스 C는 static이므로 클래스A의 생성 없이  static 으로 생성할 수 있다.
	static C field4 = new C();
	static void method2() {
		//B var1 = new B();
		C var2 = new C();
	}
	//인스턴스 멤버 클래스
	class B {}
	
	static class C {
		static int filed5;
	//인스턴스 멤버들을 가질 수 있음
	}
}
