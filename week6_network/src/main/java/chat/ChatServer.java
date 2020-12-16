package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import echo.EchoServerReceiveThread;

//  ChatServer의 주요코드
//  클라이언트로 부터 연결 요청을 기다린다.
//  클라이언트와  연결된 후,  클라이언트와 채팅 데이터 통신은 ChatServerTread가  한다.

public class ChatServer {

	public static final int PORT = 7000;
	private static final String SERVER_IP = "127.0.0.1";
	
	

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();

		try {

			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(binding): Socket Address(IP Address + Port)
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			System.out.println( "연결 기다림 " + SERVER_IP + ":" + PORT + "\n\r");

			
			// 3. 요청 대기  accept
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}

		} catch (IOException e) {
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
