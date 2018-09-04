package day0427;

public class AccountTest {

	public static void main(String[] args) {

		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("예금액: "+account.getBalance());
		
		try {
			account.withdraw(30000);
		} catch (BalanceException e) {
			String message = e.getMessage();
			System.out.println(message);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
