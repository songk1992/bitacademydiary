package practice05.prob5;

public class TestAccount {
	public static void main(String[] args) {


		Account account = new Account("078-3762-293");
		
		System.out.print( account.getAccNo() + "계좌의 잔고는 " + account.getBalance() + "만원 입니다." );
		account.save(100);
		System.out.print( account.getAccNo() + "계좌의 잔고는 " + account.getBalance() + "만원 입니다." );
		account.deposit(30);
		System.out.print( account.getAccNo() + "계좌의 잔고는 " + account.getBalance() + "만원 입니다." );
	}

}
