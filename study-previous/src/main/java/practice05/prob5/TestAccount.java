package prob5;

public class TestAccount {
	public static void main(String[] args) {

		Account account = new Account("078-3762-293");
		
		System.out.print( account.getAccNo() + "������ �ܰ�� " + account.getBalance() + "���� �Դϴ�." );
		account.save(100);
		System.out.print( account.getAccNo() + "������ �ܰ�� " + account.getBalance() + "���� �Դϴ�." );
		account.deposit(30);
		System.out.print( account.getAccNo() + "������ �ܰ�� " + account.getBalance() + "���� �Դϴ�." );
	}

}
