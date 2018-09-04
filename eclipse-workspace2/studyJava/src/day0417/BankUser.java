package day0417;

public class BankUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inmoney=1200, outmoney=1000, nowmoney=0, nowmoney1=0;
		String account="", name="";
		
		Account bankuser = new Account();
		
		account = bankuser.func1();
		name = bankuser.func2();
		nowmoney = bankuser.func3();
		
		System.out.println("*************************************");
		System.out.println("계좌번호:"+account+" 계좌명의:"+name);
		System.out.println("신규계좌 개설을 축하합니다.");
		System.out.println("*************************************");
		
		nowmoney1= Cal.calOutput(outmoney, nowmoney);
		System.out.println(outmoney+"원 출금되었습니다.");
		System.out.println("잔액은 "+nowmoney1+"원 입니다.");
		System.out.println("*************************************");
		
		nowmoney1= Cal.calInput(inmoney, nowmoney);
		System.out.println(inmoney+"원 입금되었습니다.");
		System.out.println("잔액은 "+nowmoney1+"원 입니다.");
		System.out.println("*************************************");
		
		
		
		
	}

}
