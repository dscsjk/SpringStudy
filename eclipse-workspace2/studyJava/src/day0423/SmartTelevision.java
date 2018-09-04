package day0423;

public class SmartTelevision implements RemoteControl, Searchable{

	private int volume;
	
	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println("스마트TV를 켭니다.")	;
		
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("스마트TV를 끕니다.")	;
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVolulme(int volume) {
		// TODO Auto-generated method stub
		System.out.println("현재 스마트TV 볼륨: "+volume)	;
	}
	
	public void search() {
		
	}
	
/*
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
*/
}
