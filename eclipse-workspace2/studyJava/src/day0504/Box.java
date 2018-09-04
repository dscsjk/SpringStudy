package day0504;

//public class Box {
public class Box<A,B> {
/*	
	private Object ob = new Object();
	public Object getOb() {
		return ob;
	}
	public void setOb(Object ob) {
		this.ob = ob;
	}
*/
	private A a;
	private B b;
	
	public A getA() {
		return a;
	}

	public B getB() {
		return b;
	}

	public void setAB(A a, B b) {
		this.a = a;
		this.b = b;
	}


}
