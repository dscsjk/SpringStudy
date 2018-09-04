package day0417;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car carTest1 = new Car();
		Car carTest2 = new Car("아반테","빨강");
		Car carTest3 = new Car("그랜져","회색",200);
		
		carTest1.printInfo();
		carTest2.printInfo();
		carTest3.printInfo();
	}

}
