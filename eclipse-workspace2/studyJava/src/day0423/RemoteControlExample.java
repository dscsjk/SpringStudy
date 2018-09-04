package day0423;

public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc;
		RemoteControl rc2;
		
		rc = new Television();
		rc2 = new Audio();
		
		Television telev = new Television();
		telev.turnOn();
		rc.turnOn();
		rc2.turnOn();
		
		SmartTelevision tv = new SmartTelevision();
		RemoteControl rc3 = tv;
		Searchable sch = tv;

		rc3.setMute(false);
		rc3.setVolulme(0);
		rc3.turnOff();
		rc3.turnOn();
	
/*		동일함
		tv.setMute(false);
		tv.setVolulme(0);
		tv.turnOff();
		tv.turnOn();
*/	
		
		System.out.println("리모트콘트롤"+rc3.MIN_VOLUME);
		System.out.println("써쳐블"+sch.MIN_VOLUME);
		
//		sch.search("") 동일함;
		tv.search("");
		tv.setMute(false);
		tv.turnOff();
		
		
		/*
		RemoteControl rc = new RemoteControl() {

			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setVolulme(int volume) {
				// TODO Auto-generated method stub
				
			}
			
		}
		*/
	}

}
