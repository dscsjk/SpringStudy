package day0425.test2;

import day0425.test2.Button.OnClickListener;

public class TestButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stubC
		NewButton nB = new NewButton();
		nB.SetOnClickListener(new CallListener());
		nB.touch();
		nB.SetOnClickListener(new CallListener() {
			@Override
			public void onClick() {
				System.out.println("두번째전화를 겁니다.");
			}
			
		});
		nB.touch();
		
		nB.SetOnClickListener(new MessageListener());
		nB.touch();
	}

}
