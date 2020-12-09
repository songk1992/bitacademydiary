package practice05.prob5;

public class Account {

	private String accountNo;
	private int balance;
	
	
	// 1. �Ա��� �ǹ��ϴ� deposit
	public void deposit(int amount) {
		balance += amount;
		System.out.println(accountNo + " 계좌에 " + amount +"만원이 입금되었습니다.");
		System.out.println(accountNo + " 계좌의 잔고는 " + balance +" 만원입니다.");
	}	
	
	// 2. ����� �ǹ��ϴ� withdraw
	public void withdraw(int amount) {
		balance -= amount;
		System.out.println(accountNo + " 계좌에 " + amount +"만원이 출금되었습니다.");
		System.out.println(accountNo + " 계좌의 잔고는 " + balance +" 만원입니다.");
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



	public Account(String accountNo) {
		super();
		this.accountNo = accountNo;
		this.balance = 0;
		
		System.out.println(accountNo + " 계좌가 개설되었습니다.");
		System.out.println(accountNo + " 계좌의 잔고는 " + balance +" 만원입니다.");
	}


}
