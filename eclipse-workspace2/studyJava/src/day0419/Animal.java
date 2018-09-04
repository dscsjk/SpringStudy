package day0419;

public class Animal {
	public String aniName;
	public String birthday;
	
	Animal(String s){
		aniName = s;
	}
	
	public void eat() {
		System.out.println(aniName+"가 먹어요.");
	}
}
