package day0425.test1;

public class TestOutter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outter ot = new Outter();
		Outter.Inner in = ot.new Inner();
		Outter.Inner.Center ct = in.new Center();
		
		ot.method();
		in.method();
		ct.method();
	}

}
