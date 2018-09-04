package day0418.exam.mycompany;
//내차
import day0418.exam.audi.*;
import day0418.exam.hyundai.Engine;
import day0418.exam.kumho.BigWidthTire;

public class Car {

	public Car(){
		// 금호 빅타이어
		BigWidthTire bigTire = new BigWidthTire(); 
		bigTire.setTire();
		// 아우디 엔진
		Engine hyEngine = new Engine();
		hyEngine.setEngin();
	}
		
	public void buyCar() {
		System.out.println("======= 나의차를 구입하셨어요 =======");
	}
}
