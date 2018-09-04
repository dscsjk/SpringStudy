package day0417;

public class Car {
	String model="아토스",color="흰색";
	int maxSpeed=100;
	
	Car(){}
	
	Car(String model){
		this(model, null, 0);
	}
	
	Car(String model, String color){
		this(model, color, 0);
	}
	
	Car(String model, String color, int maxSpeed){
		this.model= model;
		this.color=color;
		this.maxSpeed= maxSpeed;
	}

	public void printInfo() {
		System.out.println("모텔:"+model+" 컬러:"+color+" 최대속도:"+maxSpeed);
	}
}
