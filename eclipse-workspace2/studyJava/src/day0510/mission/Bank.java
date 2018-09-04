package day0510.mission;

public class Bank {
	private int totalMoney=0;
	 
	public synchronized void setMoney(int money ) {
		int totalMoney = this.totalMoney+money;

		if (totalMoney < 0) {
			System.out.println(Thread.currentThread().getName()+" "+money*-1+"원 출금시 잔액이 부족합니다. 잔고:"+this.totalMoney);
		} else {
			this.totalMoney = totalMoney;
			if (money < 0) {
				System.out.println(Thread.currentThread().getName()+" "+money*-1+"원 출금되었습니다. 잔고:"+this.totalMoney);
			}else {
				System.out.println(Thread.currentThread().getName()+" "+money+"원 입금되었습니다. 잔고:"+this.totalMoney);
			}
		}
	}
}
