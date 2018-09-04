package day0427;

public class TestToString {

	public static void main(String[] args) {

		String test = "";
		SmartPhone myPhone = new SmartPhone("구글","안드로이드");
		Object objMyPhone = myPhone;
		
		String myPhoneTo = myPhone.toString();
		String objTo= objMyPhone.toString();
		
		System.out.println(myPhoneTo);
		System.out.println(objTo);
		
		System.out.println(myPhone);
		System.out.println(objMyPhone);

		System.out.println(test.toString());
	}
}

class SmartPhone {
	private String company;
	private String os;
	
	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() {
		return company + ", "+os;
	}
}
