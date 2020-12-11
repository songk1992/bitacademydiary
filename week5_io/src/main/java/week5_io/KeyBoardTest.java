package week5_io;

import java.io.*;

public class KeyBoardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		
		
		//
		try {
			// 기반 스트링 (System.in, 표준입력, stdin)
			//보조 스트림1 (byte|byte|byte -> char)
			InputStreamReader isr =  new InputStreamReader(System.in, "UTF-8");
			
			//보조 스트림2 (char1|char2|char3\n -> "char1char2char3")
			br = new BufferedReader(isr);
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				if("exit".equals(line)){
					break;
				}
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error" + e);
		} catch(IOException e) {
			System.out.println("error" + e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error" + e);
			}
		}
		
	}

}
