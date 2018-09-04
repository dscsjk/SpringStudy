package day0424test;

public class Test_1 {


	public static void main(String[] args) {
		String name1 ="홍길동";
		String name2 ="이영심";

		I inf2 = new K2(name1);
		I inf3 = new K3(name2);

		A a = new A(inf2);
		a.play();
		a.playAnyone( inf2 );
		
		A b = new A(inf3);
		b.play();
		b.playAnyone( inf3);
	}

}
