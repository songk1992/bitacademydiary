package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

//	스레드의  인스턴스 변수
// 	통신을 위한 스트림을 얻어 오기 위해 Socket 객체를 저장해야 한다.
// 	연결된 클라이언트의 닉네임을 저장하고 있어야 한다. 

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	PrintWriter pw;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {

		// 1. Remote Host Information
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]\n\r");

		try {

			// 2. 스트림 얻기 ( IOStream 생성(받아오기) )
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 3.요청 처리
			String data = null;
			while (true) {
				// 데이터 읽기
				String line = br.readLine();
				if (line == null) {
					// client가 소켓을 정상 종료
					System.out.println("[server] closed by client");
					doQuit();
					break;
				}

				data = line;

				// 프로토콜 분석
				System.out.println("[server] received: " + data);

//				// 데이터쓰기
//				pw.println(data); // TODO : 앱 테스트시 사용, 실사용시 주석처리

				String[] tokens = data.split(":");

				if ("join".contentEquals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0]) || "QUIT".equals(tokens[0])) {
					doQuit();
					break;
				} else if ("whisper".equals(tokens[0]) || "WHISPER".equals(tokens[0])) {
					doWhisper(data);
				} else {
					System.out.println("에러 : 알수 없는 요청(" + tokens[0] + ")\n\r");
				}

			}

		} catch (SocketException e) {
			// client가 비정상 종료
			System.out.println("[server] suddenly closed by client\n\r");
		} catch (IOException e) {
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doQuit() {

		listWriters.remove(pw);

		doQuit(pw);
	}

	private void doQuit(Writer writer) {
		synchronized (listWriters) {
			removeWriter(writer);
		}

		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		for (int i = 0; i < listWriters.size(); i++) {
			Writer writer2 = listWriters.get(i);
			if (writer.equals(writer2.toString())) {
				listWriters.remove(i);
			}
		}
	}

	private void doMessage(String string) {
		String data = nickname + ":" + string;
		broadcast(data);
	}

	private void doWhisper(String string) {
		String[] tokens = string.split(":");
		String data = nickname + ":" + tokens[2];

		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				if (writer.equals(tokens[0])) {
					PrintWriter printWriter = (PrintWriter) writer;
					printWriter.println(data);
					System.out.println("[server] whispered: " + data);
					printWriter.flush();
				}
			}
		}

	}

	private void doJoin(String nickName, PrintWriter pw) {
		this.nickname = nickName;

		String data = nickName + "님이 참여 하였습니다";
		broadcast(data);

		/* writer pool에 저장 */
		addWriter(pw);

		//
		System.out.println("[server] join: ok \n\r");
		pw.flush();
	}

//    - addWriter 메소드의 구현 예시
//    - List인  Writer Pool 에  파라미터로  받은 Writer를 추가한다.
//    - synchronized  키워드는  여러 스레드가  하나의 공유 객체에 접근할  때,  동기화를 보장 해준다. 
	private void addWriter(PrintWriter pw) {
		synchronized (listWriters) {
			listWriters.add(pw);
		}
	}

//    - 서버에 연결된 모든 클라이언트에 메시지를 보내는(브로드캐스트) 메소드
//    - 스레드간 공유 객체인  listWriters 에 접근 하기 때문에  동기화 처리를 해 주어야 한다.
//    - PrintWriter의 메서드를 사용해야 하기 때문에  다운 캐스팅을 명시적으로 해주었다.
	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				System.out.println("[server] broadcasted: " + data);
				printWriter.flush();
			}
		}
	}

}