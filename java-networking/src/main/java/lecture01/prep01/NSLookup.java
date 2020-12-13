package lecture01.prep01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		
		while(true) {
			String str = sc.nextLine();
			
			if(str.equals("exit")) {
				break;
			}
			
			NSLookupFunc(str);
		}
		

	}

	private static void NSLookupFunc(String str) {
		try {
			InetAddress[] inetAddress = InetAddress.getAllByName(str);
			/* 여기에 정보를 출력하는 코드 추가 */
			for (InetAddress i : inetAddress) {
				System.out.println(i);
			}
			

		} catch (UnknownHostException e) {
			 e.printStackTrace();
		}
	}
}


