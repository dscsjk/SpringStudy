package day0418.exam.hyundai;
//현대차
import day0418.exam.audi.Engine;
import day0418.exam.kumho.Tire;
public class Car {

	public Car(){
			// 금호 타이어
			Tire tire = new Tire(); 
			tire.setTire();
			// 아우디 엔진
			Engine engine1 = new Engine();
			engine1.setEngin();

	}
	public void buyCar() {
		System.out.println("======= 현대차를 구입하셨어요 =======");
	}
}