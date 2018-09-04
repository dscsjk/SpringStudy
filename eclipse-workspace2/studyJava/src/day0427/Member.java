package day0427;

public class Member {
	String id, password;
	public Member(String id, String password ) {
		this.id = id;
		this.password = password;
	}

	public void checkId(String id ) throws BalanceException, Exception {
		System.out.println("ID체크: "+id);
		if (this.id != id) {
			throw new NotExistIDException("ID를 잘못 입력하셨습니다.");
		}
	}
	
	public void checkPassword(String password) throws WrongPasswordException, Exception {
		System.out.println("패스워드체크: "+password);
		if (this.password != password) {
			throw new WrongPasswordException("패스워드를 잘못 입력하셨습니다.");
		}
	}
}
