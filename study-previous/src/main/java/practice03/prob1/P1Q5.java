package practice03.prob1;

public class P1Q5 {

	public static void main(String[] args) {
		int[] data = {1, 3, 5, 8, 9, 11, 15, 19, 18, 20, 30, 33, 31};
		
		/* 코드추가 */
		check3(data);
		
		
		

	}

    private static int[] check3(int[] data) {

    	
    	int count = 0;
    	int sum = 0;
    	
		for(int i = 0; i < data.length; i++) {
			int value = data[i];
			if(isMulOf3(value)) {
				count++;
				sum += value;
			}
		}
		
		System.out.println("주어진 배열에서 3의 배수의 개수=> " + count);
		System.out.println("주어진 배열에서 3의 배수의 합=> " + sum);
		
		return data;
	}
    
    private static boolean isMulOf3(int a) {
    	if (a%3 == 0) {
    		return true;
    	}
    	else
    		return false;
    }
}
