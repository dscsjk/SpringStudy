package day0425;

public class TestA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A a = new A();
		A.B b = a.new B();
		
		b.field1 = 3;
		b.method1();
		
		A.C c = new A.C();
		A.C d = new A.C();
	
		c.field1 =0;
		c.field2 =0;
		c.field3 = "테스트1";
		
		d.field1 =3;
		c.field2 =5;
		d.field3 = "테스트2";
		c.method1();
		d.method1();
	
		A.C.field3="Good!";
		A.C.method2();
		
		A.D.field2 = 12;
		A.D.field3 = "테스트3";
		A.D.method3();
		a.method();
	}
}
