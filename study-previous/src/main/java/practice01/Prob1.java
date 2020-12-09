
//		문제1. java.util.Scanner 클래스를 이용하여 입력된 수가 3의 배수인지 판별하는 프로그램을
//      작성하세요.

package practice01;

import java.util.Scanner;

public class Prob1 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        if(k%3 == 0){
            System.out.println("3의 배수입니다.");
        }
        else
        {
            System.out.println("3의 배수가 아닙니다.");
        }
        sc.close();
    }
}
