package day0416;

public class PhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone Phone = new Phone();
		Phone Phone2 = new Phone("롤리팝2");
		Phone Phone3 = new Phone("아이스크림","검정");
		Phone Phone4 = new Phone("키켓",false);
		
		Phone.printVersion();
	}

}
