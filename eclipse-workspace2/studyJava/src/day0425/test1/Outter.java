package day0425.test1;

public class Outter {
	String field = "Outter-field";
	
	void method() {
		String field = "Outter-method-field";
		System.out.println("2.->"+field);
		System.out.println("1.->"+this.field);
		System.out.println();
		
	}
	
	class Inner {
		String field = "Inner-field";
		
		void method() {
			String field = "Inner-method-field";
			System.out.println("3.->"+field);
			System.out.println("2.->"+this.field);
			System.out.println("1.->"+Outter.this.field);
			System.out.println();
		}
		
		class Center {
			String field = "Center-field";
			
			void method() {
				String field = "Center-method-field";
				System.out.println("4.->"+field);
				System.out.println("3.->"+this.field);
				System.out.println("2.->"+Outter.this.field);
				System.out.println("1.->"+Outter.Inner.this.field);
			}
			
		}
	}
	
}
