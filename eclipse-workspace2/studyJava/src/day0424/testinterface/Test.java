package day0424.testinterface;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplInf ic = new ImplInf();
		ic.methodA();
		ic.methodB();
		ic.methodC();
	
		InterfaceA infA = ic;
		infA.methodA();
		
		InterfaceB infB = ic;
		infB.methodB();

		InterfaceC infC = ic;
		infC.methodA();
		infC.methodB();
		infC.methodC();
	}

}
