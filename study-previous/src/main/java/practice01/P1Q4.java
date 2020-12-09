package practice01;

import java.util.Scanner;

public class P1Q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i=0;i<=str.length();i++){
            for(int j=0;j<i;j++){
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}
