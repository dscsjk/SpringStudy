package day0420;

public class ChildExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal ani = new Cat();

		//Animal ani = new Animal();
		ani.name = "동물이름";
		ani.eat();
		ani.sleep();
		//ani.jump();
		/*
		Cat cat = (Cat)ani;
		cat.jump();
		*/
		if(ani instanceof Cat) {
			Cat c = (Cat)ani;
			c.jump();
			c.catName="kitty";
		}
	}

}
