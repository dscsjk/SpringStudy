package day0413;

public class Student {
	private String name ;
	private String sNumber1, sNumber2;

	Student(){}
	Student( String name1, int number) {
		
		name = name1;
		setStudentNumber(number);
	}
	
	String getName () {
		return name;
	}

	void setName() {
		name = "김말똥";
	}
	
	String getStudentNumber() {
		return sNumber1;
	}

	void setStudentNumber(int inumber) {
		sNumber1 = "000"+inumber;
	}

	void setStudentNumber(int inumber1, int inumber2) {
		String test = Integer.toString(inumber1);
		
		sNumber1 = "000"+ test.substring(0, inumber2);
	}
}
