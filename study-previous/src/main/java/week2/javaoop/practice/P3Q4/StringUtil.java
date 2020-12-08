package week2.javaoop.practice.P3Q4;

public class StringUtil {
    public static String concatenate(String[] str) {
    	
    	String ans = "";
    	
    	for(String letter : str) {
    		ans += letter;
    	}

		return ans;
        //문자열을 결합하여 리턴 하는 메소드 구현
    }
}



