package day0416;

public class Phone {
	String version="누가";
	String color="빨강";
	boolean noteIs=false;
	
	Phone(){
		version="롤리팝";
	}
	
	Phone(String v){
		System.out.println(v);
	}
	Phone(String v, String c){
		System.out.println(v);
		System.out.println(c);
	}
	Phone(String v, boolean note){
		System.out.println(v);
		System.out.println(note);
	}
	public void printVersion() {
		setVersion("oreo");
		System.out.println(version);
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
