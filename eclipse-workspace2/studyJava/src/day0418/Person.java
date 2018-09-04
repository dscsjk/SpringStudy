package day0418;

public class Person {
	public static final String DB_NAME = "PERSION_DB";
	
	final String nation = "Korea";
	final String ssn;
	String name;
	
	private Person() {
		this.ssn="1234";
		this.name = "name";
	}
	
	public Person (String ssn, String name) {
		this.ssn=ssn;
		this.name = name;;
	}
}
