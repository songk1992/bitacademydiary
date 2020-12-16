package chat.client.win;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import chat.ChatClientThread;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private static TextArea textArea;
	Socket socket;
	String name;
	String message;
	BufferedReader br;
	PrintWriter pw;
	
	public static void AddStringToTextArea(String data) {
		textArea.append(data);
		textArea.append("\n");
	}

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		this.name = name;
	}

	public void show() {
		/*
		 * 1. UI 초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("채팅방 나오기 프로토콜 구현...");
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		

		try {
			
			/*
			 * 2. IOStream 초기화
			 */
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			
			/*
			 * 3. 쓰레드 생성
			 */
			new WindowChatClientThread(socket, br).start();
			
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		

	}
	
	private void sendMessage() {
		message = textField.getText();
		textField.setText("");
		textField.requestFocus();
		
		
		// 소켓을 통해 전송
		boolean pw_on = true;
		
		if(message.contains("join:")) {
			System.out.println("불가능한 명령어입니다.");
			System.out.println("다시 입력해주세요.");
			pw_on = false;
		}
		else if(message.contains("help") || message.contains("HELP")) {
			System.out.println("사용가능한 명령어 목록");
			pw_on = false;
		}
		else if(message.contains("quit") || message.contains("QUIT")) {
			
		}
		else {
			message = "message: " + message;
		}
		
		if(pw_on) {
			pw.println(message);
		}

	}


	
	
	public class WindowChatClientThread extends ChatClientThread{
		

		public WindowChatClientThread(Socket socket, BufferedReader br) {
			super(socket, br);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			setData(message);
			super.run();

			textArea.append(getData());
		}

	}
}