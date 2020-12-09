
//	문제2. 출력 값이 다음과 같도록 Prob2 클래스의 main 메쏘드를 완성하십시오.
//	실행 결과: 
//	1 2 3 4 5 6 7 8 9 10
//	2 3 4 5 6 7 8 9 10 11
//	3 4 5 6 7 8 9 10 11 12
//	4 5 6 7 8 9 10 11 12 13
//	5 6 7 8 9 10 11 12 13 14
//	6 7 8 9 10 11 12 13 14 15
//	7 8 9 10 11 12 13 14 15 16
//	8 9 10 11 12 13 14 15 16 17




package practice01;

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 10;
        for(int i = 0; i<n-1; i++){
            for(int j = 1; j<=n; j++){
                System.out.print(i+j +" ");
            }
            System.out.println();
        }
	}

}
