package day0423;

public class SmartPhone extends Phone {

	SmartPhone(String owner){
		super(owner);
	}

	@Override
	public void turnOn() {
		System.out.println(super.owner+"스마트폰 전원을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println(super.owner+"스마트폰 전원을 끕니다.");
	}
	
	public void internetSearch() {
		System.out.println(super.owner+"인터넷 검색을 합니다.");
	}

	@Override
	public void call() {
		System.out.println("스마트폰에서 전화를 겁니다.");
		
	}
	

	
}
