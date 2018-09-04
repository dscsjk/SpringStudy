package day0430;

public class StringCharAtexample {

	public static void main(String[] args) {
		
		
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);
		
		switch(sex) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
			
		}
		
		String [] std = {"미소초등학교1학년2반김혜진"
						,"미소초등학교3학년4반이미니"
						,"미소초등학교1학년1반박소영"
						,"미소초등학교1학년4반이영준"
						,"미소초등학교5학년3반박이쁨"};
		
		for(int i=0; i<std.length; i++) {
			if ( std[i].charAt(6) =='1')
				System.out.println(std[i]);
		}
	}
}
