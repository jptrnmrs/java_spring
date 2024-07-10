package sub2;

public class Account {

	
	private String bank;
	private String acc;
	private String name;
	private int balance;
	
	public Account(String bank,String acc,String name,int balance) {

		this.bank = bank;
		this.acc = acc;
		this.name = name;
		this.balance = balance;	
	}
	
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBank() {
		return bank;
	}
	public String getName() {
		return name;
	}
	
	
	public void deposit(int balance) {
		this.balance += balance;
	}
	
	public void withdraw(int balance) {
		this.balance -= balance;
	}
	
	public void show() {
		System.out.println("---------------------");
		System.out.println("은행명 : " + this.bank);
		System.out.println("계좌번호 : " + this.acc);
		System.out.println("예금주 : " + this.name);
		System.out.println("현재잔액 : " + this.balance);
		System.out.println("---------------------");
	}
}
