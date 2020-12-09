package practice04.prob1;
import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
			System.out.print( "숫자를 입력하세요. :" );
			int inputNumber = scanner.nextInt();
			int sum = 0;
			int modifier = 0;
			
			if(isOdd(inputNumber)) {
				modifier++;
			}
			
			for(int i = modifier; i<=inputNumber;i+=2) {
				sum += i;
			}
			
			System.out.print( sum );
		
		scanner.close();
	}

	private static boolean isOdd(int inputNumber) {
		if(inputNumber%2 == 1) {
			return true;
		}else
		return false;
	}
	


}