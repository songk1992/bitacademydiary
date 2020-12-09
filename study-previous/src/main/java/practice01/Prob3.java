
//	문제3. 반복문을 이용하여 369게임에서 박수를 쳐야 하는 경우의 수를 순서대로 화면에
//	       출력해보세요. 1부터 99까지만 실행하세요.


package practice01;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 0;
        int tempVal = 1;

        if(num % 2 == 0){
            tempVal = 0;
            answer += num;
        }

        for(int i=0;i<num;i+=2){
            answer += (i+ tempVal);
        }

        System.out.println(answer);
    }
}

