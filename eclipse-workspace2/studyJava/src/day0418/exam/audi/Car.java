package day0418.exam.audi;

import day0418.exam.kumho.BigWidthTire;

//아우디차
public class Car {

	public Car(){
		// 금호 빅타이어
		BigWidthTire bigTire = new BigWidthTire(); 
		bigTire.setTire();
		// 아우디 엔진
		Engine engine1 = new Engine();
		engine1.setEngin();
	}
	
	public void buyCar() {
		System.out.println("======= 아우디를 구입하셨어요 =======");
	}
}
