package week5_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = null;
		
		try {
		File file = new File("phone.txt");
		System.out.println("===================파일정보========================");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length() + "bytes");
		
//		Long time = file.lastModified();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String sTime = sdf.format(time);
//		System.out.println(sTime);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(file.lastModified()));
		
		
		
		System.out.println("===================전화번호========================");
		scanner = new Scanner(file);
		
		while(scanner.hasNextLine()) {
			String name = scanner.next();
			String phone1 = scanner.next();
			String phone2 = scanner.next();
			String phone3 = scanner.next();
			
			System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);
		}
		}catch(FileNotFoundException ex){
			System.out.println("error:" + ex);
		}finally {
			if(scanner != null) {
				scanner.close();
			}

		}

	}

}
