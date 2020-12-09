package practice01;

import java.util.Scanner;
import java.util.Random;

public class P2Q5 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        while (true) {
            boolean isWrong = true;
            System.out.println("수를 결정하였습니다 맞추어 보세요");
            System.out.println("1-100");


            int k = r.nextInt(100) + 1;
            int counter = 0;

            while (isWrong) {
                int guessNum = scanner.nextInt();
                counter++;
                System.out.println(counter + ">>" + guessNum);

                if(guessNum > k){
                    System.out.println("더 낮게");
                }
                else if(guessNum < k){
                    System.out.println("더 높게");
                }
                else {
                    System.out.println("맞았습니다");
                    isWrong = false;
                }
            }



            System.out.println("다시하시겠습니까?(y/n)");

            String answer = scanner.next();
            if (answer.equals("y")) {
                break;
            }

        }


    }

}