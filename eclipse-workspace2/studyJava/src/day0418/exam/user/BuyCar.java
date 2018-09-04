package day0418.exam.user;

import day0418.exam.audi.*;
import day0418.exam.hyundai.*;
import day0418.exam.mycompany.*;

public class BuyCar {

	public static void main(String[] args) {
		day0418.exam.audi.Car adCar = new day0418.exam.audi.Car();
		adCar.buyCar();
		day0418.exam.hyundai.Car hyCar = new day0418.exam.hyundai.Car();
		hyCar.buyCar();
		day0418.exam.mycompany.Car myCar = new day0418.exam.mycompany.Car();
		myCar.buyCar();
	}

}
