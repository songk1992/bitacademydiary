package week2.javaoop.practice.P3Q3;

public class CurrencyApp {
	

	
	
	public static void main(String[] args) {
		double millionWon = 1000_000; 
		double hundredDollar = 100; 
		CurrencyConverter.setRate(1000);
		
		System.out.println("백만원은 " + CurrencyConverter.toDollar(millionWon) + "달러입니다");
		System.out.println("백달러는 " + CurrencyConverter.toKRW(hundredDollar) + "원입니다");
	}
}
