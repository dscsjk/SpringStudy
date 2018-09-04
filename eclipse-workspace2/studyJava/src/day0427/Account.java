package day0427;

public class Account {
	private long balance;
	
	public Account() {}

	public long getBalance() {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) throws BalanceException, Exception {
		if (balance < money) {
			//throw new BalanceException("잔고부족"+(money-balance)+"모자람");
		}
		balance -= money;
		String[] name = new String[5];
		name[5]= "홍길동"; // ArrayIndexOutOfBoundsException 발생
	}
}	
