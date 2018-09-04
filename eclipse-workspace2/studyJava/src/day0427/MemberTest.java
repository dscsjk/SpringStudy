package day0427;

public class MemberTest {

	public static void main(String[] args) {

		Member member = new Member("홍길동","1234567");
		System.out.println("ID: "+member.id+"  Password: "+member.password);
		
		try {
			member.checkId("김수정");
		} catch (NotExistIDException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			member.checkPassword("1234568");
		} catch (WrongPasswordException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
