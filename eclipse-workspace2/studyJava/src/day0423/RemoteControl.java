package day0423;

public interface RemoteControl {
	//public static final int MAX_VOLUME = 10;
	int MAX_VOLUME = 10; //동일
	int MIN_VOLUME = 0; 
	
	//public abstract void 생략  무조건 public
	void turnOn();
	void turnOff();
	void setVolulme(int volume);

	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음처리합니다.");
		} else {
			System.out.println("무음해제합니다.");
		}
	}

	default void getMute(boolean mute) {
	}
	
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
