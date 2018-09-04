package day0417;

public class MemberServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		
		if (result) {
			System.out.println("로그인되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("패스워드가 올바르지 않습니다.");
		}

	}

}
