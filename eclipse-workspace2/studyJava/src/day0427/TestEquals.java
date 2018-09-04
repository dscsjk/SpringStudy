package day0427;

public class TestEquals {
	public static void main(String[] args) {
		
		Member1 member1 = new Member1("blue");
		Member1 member2 = new Member1("blue");
		Member1 member3 = new Member1("red");

		if (member1.equals(member2)) {
			System.out.println("멤버1과 멤버2는 같습니다.");
		} else {
			System.out.println("멤버1과 멤버2는 같지 않습니다.");
		}
		
		if (member1.equals(member3)) {
			System.out.println("멤버1과 멤버3은 같습니다.");
		} else {
			System.out.println("멤버1과 멤버3은 같지 않습니다.");
		}
	}
}

class Member1 { 
	public String id;
	public Member1(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member1) {
			Member1 member = (Member1)obj;
			System.out.println(id);
			System.out.println(member.id);
			
			if(id.equals(member.id)) {
				return true; 
			}
		}
		return false;
	}
	
}
