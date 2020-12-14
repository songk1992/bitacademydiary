package lecture02.practice04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			
			// 1. 서버 socket 생성
			serverSocket = new ServerSocket();
			
			
			// 2. 바인딩(binding)
			serverSocket.bind( new InetSocketAddress( "127.0.0.1", 6000 ) ); // telnet localhost 10001
			System.out.println( "[서버] 연결 기다림");
			

			// 3. accept
			Socket socket = serverSocket.accept();
			
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			System.out.println( "[서버] 연결됨 from " + 
					remoteHostAddress + ":" );
			
			try {
			// 4. IOStream 받아 오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			while(true) {
				
				// 5. 데이터 일기
				byte[] buffer = new byte[256];
				int readByteCount = is.read(buffer); // blocking
				
				if(readByteCount == -1) {
					// client가 소켓을 정상적으로 종료
					System.out.print("[server] closed by client");
					break;
				}
				
				String data = new String(buffer, 0, readByteCount, "UTF-8");
				System.out.println("[server] received  " + data);
				
				// 6. 데이터 쓰기
				os.write(data.getBytes("utf-8"));
				
			}
			
			}catch (IOException e) {
				System.out.print("[server] error " + e);
			}finally {
				try {
					socket.close();
				}catch (IOException e) {
					e.printStackTrace();
				}

			}
			
		
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if( serverSocket != null && serverSocket.isClosed() == false ) {
				try {
					serverSocket.close();
				}catch( IOException ex ) {
					ex.printStackTrace();
				}

		}
	}
}
}
