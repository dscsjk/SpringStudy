package day0424;

public abstract class K implements I,J {

	@Override
	public void play() {
		System.out.println("K의 놀이시간.");
		
	}

	@Override
	public void study() {
		System.out.println("K의 공부시간.");
		
	}

	//readBooK구현을 원하지 않을시
	//추상메소드로 선언하고 이로 인해 클래스도 추상클래스가 됨
	public abstract void readBook();

	

}
