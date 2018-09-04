package day0423;

public class PhoneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone p = new SmartPhone("sss");
		p.turnOff();
		p.turnOn();
		SmartPhone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOff();
		smartPhone.turnOn();
		smartPhone.internetSearch();
		
		DmbPhone dmbPhone = new DmbPhone("영심이");
		dmbPhone.call();

	}

}
