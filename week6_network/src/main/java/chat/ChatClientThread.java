package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

import chat.client.win.ChatWindow;

public class ChatClientThread extends Thread {

	Socket socket;
	BufferedReader br;
	String data;

	public ChatClientThread(Socket socket, BufferedReader br) {
		this.socket = socket;
		this.br = br;
	}

	@Override
	public void run() {

		while(true) {
			try {
				data = br.readLine();
				if (data == null) {
					// server가 소켓을 정상 종료
					System.out.println("[client] closed by server");
					return;
				}
				System.out.println( data );
				
				ChatWindow.AddStringToTextArea(data);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


}
