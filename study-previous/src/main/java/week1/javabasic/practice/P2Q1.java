package week1.javabasic.practice;

import java.util.Scanner;

public class P2Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] coinArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
        int numberOfCoins = 0;
        for (int i = 0; i < coinArr.length; i++) {
            if (num >= coinArr[i]) {
                int tempCoin;
                tempCoin = num / coinArr[i];
                System.out.println(coinArr[i] + "원 : " + tempCoin + " 개");
                numberOfCoins += tempCoin;
                num = num % coinArr[i];
            }
//    if (num == 0) {
//        break;
//    }
        }
        System.out.println("총 " + numberOfCoins + "개");

    }
}
