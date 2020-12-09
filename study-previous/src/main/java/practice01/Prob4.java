




package practice01;

import java.util.Scanner;
import java.util.Random;

//	문제4. 숨겨진 카드의 수를 맞추는 게임입니다. 1-100까지의 임의의 수를 가진 카드를 한 장
//	숨기고 이 카드의 수를 맞추는 게임입니다. 아래의 화면과 같이 카드 속의 수가 57인 경
//	우를 보면 수를 맞추는 사람이 40이라고 입력하면 "더 높게", 다시 75이라고 입력하면
//	"더 낮게" 라는 식으로 범위를 좁혀가며 수를 맞추고 있습니다. 게임을 반복하기 위해
//	 y/n이라고 묻고 n인 경우 종료됩니다..

public class Prob4 {


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