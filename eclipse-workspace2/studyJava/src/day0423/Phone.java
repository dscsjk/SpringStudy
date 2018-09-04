package day0423;

public abstract class Phone {
	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}

	public void turnOn() {
		System.out.println(owner+"폰 전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println(owner+"폰 전원을 끕니다.");
	}
	
	public abstract void call();
}
