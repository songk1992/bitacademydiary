package practice02;

public class CurrencyApp {
	

	
	
	public static void main(String[] args) {
		double millionWon = 1000_000; 
		double hundredDollar = 100; 
		CurrencyConverter.setRate(1000);
		
		System.out.println("�鸸���� " + CurrencyConverter.toDollar(millionWon) + "�޷��Դϴ�");
		System.out.println("��޷��� " + CurrencyConverter.toKRW(hundredDollar) + "���Դϴ�");
	}
}
