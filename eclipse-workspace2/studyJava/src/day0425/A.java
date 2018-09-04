package day0425;

public class A {

	class B {
		int field1;
		void method1() {
			System.out.println("field1->"+field1);
		}
	}

	static class C {
		int field1;
		static int field2;
		static String field3="";
		void method1() {
			System.out.println("field1->"+field1);
		}
		static void method2() {
			System.out.println("field2->"+field2);
			System.out.println("field3->"+field3);
		}
	}

	static class D {
		static int field2;
		static String field3="";
		static void method3() {
			System.out.println("클래스안의 스태틱클래스 안의 스태틱메소드3");
			System.out.println("field2->"+field2);
			System.out.println("field3->"+field3);
		}
	}
	
	void method() {
		class E {
			int field1;
			void method1() {
				System.out.println("메소드내의 클래스 안의 메소드1");
				System.out.println("field1->"+field1);
				
			}
		}
		E e = new E();
		e.field1=3;
		e.method1();

		class F {
			int field1;
			void method1() {
				
			}
		}
	}
}
