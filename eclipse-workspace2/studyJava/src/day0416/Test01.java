package day0416;

public class Test01 {

	int i;
	String s;
	double d;
	Test01(){
		i=1;
		s="없음";
	}

	Test01(int i, String s) {
		this.i = i;
		this.s = s;
		
	}
	
	Test01(int i, String s, double d) {
	this( i,s );
	this.d = d;
	}

}

class Test02 {

	int i;
	String s;
	double d;
	Test02(){}

	Test02(int i, String s) {
		this.i = i;
		this.s = s;
		
	}
	
	Test02(int i, String s, double d) {
	this( i,s );
	this.d = d;
	}

}
