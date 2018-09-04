package day0416;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test01 test01 = new Test01();
		Test01 test02 = new Test01(2,"테스트");
		Test01 test03 = new Test01(3,"테스트 ", 3.4);
		
		System.out.println("갯수->"+ test01.i+" 이름->"+test01.s+" 값"+test01.d);
		System.out.println("갯수->"+ test02.i+" 이름->"+test02.s+" 값"+test02.d);
		System.out.println("갯수->"+ test03.i+" 이름->"+test03.s+" 값"+test03.d);
		
	}

}
