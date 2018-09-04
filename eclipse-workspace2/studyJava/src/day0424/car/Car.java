package day0424.car;

public class Car {
	public Tire frontLeftTire = new HankookTire();
	public Tire frontRightTire = new HankookTire();
	public Tire backLeftTire = new HankookTire();
	public Tire backRightTire = new HankookTire();
	
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
	
	void changeTire() {
		frontLeftTire = new KumhoTire();
		frontRightTire = new KumhoTire();
	}
}
