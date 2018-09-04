package day0426;

public class ClassCastExceptionExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
	}

	public static void changeDog(Animal animal) {
		try {
			Dog dog = (Dog) animal;
			System.out.println("Dog입니다.");
		} catch (ClassCastException e) {
			System.out.println("Dog이 아닙니다.");
			e.printStackTrace();
		}
	}

}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
