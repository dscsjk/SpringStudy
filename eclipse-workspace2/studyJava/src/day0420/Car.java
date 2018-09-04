package day0420;

public class Car {
	
	Tire frontLeftTire = new Tire("앞왼쪽   ",6);
	Tire frontRightTire = new Tire("앞오른쪽",2);
	Tire backLeftTire = new Tire("뒤왼쪽   ",3);
	Tire backRightTire = new Tire("뒤오른쪽",4);
//	Tire frontLeftTire ;
//	Tire frontRightTire ;
//	Tire backLeftTire ;
//	Tire backRightTire ;
	
	int run() {
		int status=0;
		
		System.out.println("자동차가 달립니다.");
		if (frontLeftTire.roll()==false) {status = 1;}
		if (frontRightTire.roll()==false) {status = 2;}
		if (backLeftTire.roll()==false) {status= 3;}
		if (backRightTire.roll()==false) {status= 4;}
		if (status >0)
			stop();
		return status;
	}
	
	void stop() {
		System.out.println("자동차가 멈춥니다.");
		
	}

}
