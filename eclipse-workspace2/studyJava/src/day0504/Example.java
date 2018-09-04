package day0504;

public class Example {

	public static void main(String[] args) {
		/*
		Box box = new Box();
		box.setOb("이름");
		
		System.out.println(box.getOb());
		Apple ap = new Apple();
		box = ap.boxing("홍길동", 100);
		System.out.println(box.getOb());
		*/

		Box<String, Integer> box = new Box<>();
		box.setAB("이름",100);
		System.out.println(box.getA());
		System.out.println(box.getB());
		Apple ap = new Apple();
		box = ap.boxing("홍길동", 200);
		System.out.println(box.getA());
		System.out.println(box.getB());
	}

}
