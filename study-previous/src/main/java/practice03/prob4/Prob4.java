package practice03.prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        int intArray[] = new int[5];
        double sum = 0;

        /* 키보드에서 배열 크기만큼 입력 받아 배열에 정장하는 코드 */
        for(int i=0; i<intArray.length; i++) {
        	intArray[i] = in.nextInt();
            /* 배열에 저장된 정수 값 더하기 */
        	sum += intArray[i];
        }

        
        /* 출력 */
        for(int i=0; i<intArray.length; i++) {
        	
        }
        
        System.out.println(sum);
        
        
        in.close();
	}

}