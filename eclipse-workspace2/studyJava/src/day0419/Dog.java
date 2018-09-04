package day0419;

public class Dog extends Animal {
	Dog(){
		super("강아지");
	}	
	
	@Override
	public void eat() {
		System.out.println("사료를 먹어요.");
	}

	public void allEat() {
		super.eat();
		eat();
	}
}
