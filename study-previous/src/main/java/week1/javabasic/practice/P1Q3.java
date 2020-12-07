package week1.javabasic.practice;

import java.util.Scanner;

public class P1Q3 {

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

