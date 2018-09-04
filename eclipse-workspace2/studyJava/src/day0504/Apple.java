package day0504;

public class Apple {

	public <A,B> Box<A,B> boxing(A a, B b) {
		Box<A,B> box = new Box<>();
		box.setAB(a, b); 
		return box;
	}

}
