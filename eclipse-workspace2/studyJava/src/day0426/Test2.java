package day0426;

public class Test2 {

	public static void main(String[] args) {
		B b = new B();
		try {
			b.setName();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.printf("C.ArrayIndexOutOfBoundsException...........\n다시 실행하세요.\n");
		} finally {
		}
	}
}

class B {
	public void setName() throws ArrayIndexOutOfBoundsException {
		A a = new A();
		//NullPointerException 처리
		try {
			a.setTosslength(null);
		} catch (NullPointerException e) {
			System.out.println("B.NullPointerException...........");
		} finally {
			try {
				a.setTossName();;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.printf("B.ArrayIndexOutOfBoundsException...........\n다시 실행하세요.\n");
			} 
			// ArrayIndexOutOfBoundsException 던짐
			a.setTossName();
		}
	}
}

class A {
	public void setTosslength(String length) throws NullPointerException {
		// NullPointerException 발생가능
		String reLen = length.toString();
	}
	public void setTossName() throws ArrayIndexOutOfBoundsException {
		String[] name = new String[5];
		// ArrayIndexOutOfBoundsException 발생 가능
		name[5]= "홍길동";
	}
}