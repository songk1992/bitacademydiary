package lecture02.practice04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int  SERVER_PORT = 6000;
			
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {

	// 1. 소켓 생성
		socket = new Socket();
		
		// 2. 서버 연결
		socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
		System.out.println("[Client] conneted");
		
		// 3. IOStream 받아오기
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		// 4. 쓰기
		String data = "Hell World";
		os.write(data.getBytes("UTF=8"));
		
		// 5. 읽기
		byte[] buffer = new byte[256];
		int readByteCount = is.read(buffer);
		
		if(readByteCount == -1) {
			// server 정상종료
			System.out.println("[Client] closed by server");
			return;
		}
		
		new String(buffer, 0, readByteCount, "UTF-8");
		System.out.println("[Client] received : " + data);
		
		
		} catch (IOException e) {
			System.out.println("[Client] error" + e);
		}finally {
			try {
				if (socket != null && !socket.isClosed())
				socket.close();
			} catch (IOException e) {
				System.out.println("[Client] error" + e);
			}
		}
	
	}
}
