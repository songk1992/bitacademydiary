package lecture02.practice02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind( new InetSocketAddress( "localhost", 10001 ) ); // telnet localhost 10001
			System.out.println( "[서버] 연결 기다림");
			Socket socket = serverSocket.accept();

			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			System.out.println( "[서버] 연결됨 from " + 
			                    inetSocketAddress.getHostName() + ":" + 
			                    inetSocketAddress.getPort() );

			socket.close();  
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
