package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			//1. Scanner 생성(표준입력, 키보드 연결)
			scanner = new Scanner(System.in);
			
			//2. 소켓 생성
			socket = new Socket();
			
			
			//3. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			System.out.println("[client] connected!");
			
			//4. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			
			int numberOfComments = 0;
			
			while(true) {

				new ChatClientThread(socket, br).start();
				
		
				String line;
				boolean pw_on = true;
				
				//5. 키보드 입력 받기
				if(numberOfComments == 0) {
					System.out.print("닉네임을 입력해주세요 : ");
					line = "join:" + scanner.nextLine();
					
				}else {
					System.out.print(">>");
					line = scanner.nextLine();
					
					if(line.contains("join:")) {
						System.out.println("불가능한 명령어입니다.");
						System.out.println("다시 입력해주세요.");
						pw_on = false;
					}
					else if(line.contains("help") || line.contains("HELP")) {
						System.out.println("사용가능한 명령어 목록");
						pw_on = false;
					}
					else if(line.contains("quit") || line.contains("QUIT")) {
						
					}
					else {
						line = "message: " + line;
					}
					
				}
				
				//6. 소켓쓰기
				if(pw_on) {
					pw.println(line);
				}
				
				
				numberOfComments++;
			
			}
			
			
			
		} catch(SocketException e) {
			// server 비정상 종료
			System.out.println("[clinet] suddenly closed by server");
		} catch (IOException e) {
			System.out.println("[client] error:" + e);
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && !socket.isClosed())
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}