package day0418;

public class Singleton {
	private static Singleton singleton = new Singleton();
	
	String nation = "Korea";
	String ssn;
	
	private Singleton() {}
	
	public Singleton( String ssn ) {
		this.ssn=ssn;
	}
	
	static Singleton getInstance() {
		return singleton;
	}
	
	

}
