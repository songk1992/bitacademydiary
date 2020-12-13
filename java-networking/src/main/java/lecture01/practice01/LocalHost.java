package lecture01.practice01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			/* 여기에 정보를 출력하는 코드 추가 */		
			System.out.println(inetAddress);
		} catch (UnknownHostException e) {
			 e.printStackTrace();
		}
	}
}




