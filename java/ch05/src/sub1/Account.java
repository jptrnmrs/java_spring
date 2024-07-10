package sub1;

public class Account {

	
	String bank;
	String acc;
	String name;
	int balance;
	
	public void deposit(int balance) {
		this.balance += balance;
	}
	
	public void withdraw(int balance) {
		this.balance -= balance;
	}
	
	public void show() {
		System.out.println("은행명 : " + this.bank);
		System.out.println("계좌번호 : " + this.acc);
		System.out.println("예금주 : " + this.name);
		System.out.println("현재잔액 : " + this.balance);
	}
}
