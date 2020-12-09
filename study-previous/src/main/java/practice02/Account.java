package practice02;

public class Account {

	private String accountNo;
	private int balance;
	
	
	// 1. �Ա��� �ǹ��ϴ� deposit
	public void deposit(int amount) {
		balance += amount;
		System.out.println(accountNo + " ���¿�  " + amount +"������ �ԱݵǾ����ϴ�.");
		System.out.println(accountNo + " ������ �ܰ�� " + balance +"�����Դϴ�.");
	}	
	
	// 2. ����� �ǹ��ϴ� withdraw
	public void withdraw(int amount) {
		balance -= amount;
		System.out.println(accountNo + " ���¿�  " + amount +"������ ��ݵǾ����ϴ�.");
		System.out.println(accountNo + " ������ �ܰ�� " + balance +"�����Դϴ�.");
	}
	
	
	
	// 3. getter / setter
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}



	public Account(String accountNo, int balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		
		System.out.println(accountNo + " ���°� �����Ǿ����ϴ�.");
		System.out.println(accountNo + " ������ �ܰ�� " + balance +"�����Դϴ�.");
	}


}
