package chat.client.win;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {

	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {

		String name = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		

		
		
		try {
			
			//1. socket 생성
			socket = new Socket();

			//2. connect to Server
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			//3. iostream 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//4. join 프로토콜 요청 및 처리
			//5. join 프로토콜 응당이 성공이면
			pw.println("join:" + name);
			scanner.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//   new ChatWindow(name, socket).show();
		new ChatWindow(name, socket).show();
	}

}