package homwork.day0510;

public class Customer extends Thread {
	Bank bank;
	int money;
	Customer(Bank bank, int money, String name) {
		this.bank = bank;
		this.money = money;
		this.setName(name);
	}
	
	public void run() {
		if (this.money != 0)
			this.bank.setMoney(this.money);
	}
}
