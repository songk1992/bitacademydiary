// 3의 배수인지 판별하는 프로그램

package week1.javabasic.practice;

import java.util.Scanner;

public class P1Q1 {
	
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
    }
}
