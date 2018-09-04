package day0510.mission;


public class MainThreadExample {

	public static void main(String[] args) {
		// 계좌생성후 잔고 10,000원 설정
		Bank bank = new Bank();
		bank.setMoney(10000);
		
		// 고객 라이언은 10,000원 출금을 원한다.
		Customer ryan = new Customer(bank, -10000, "ryan");
		// 고객 모니카 5,000월 출금을 원한다.
		Customer monica = new Customer(bank, -5000, "monica");
		
		// 업무 시작
		ryan.start();
		monica.start();
	}
}
