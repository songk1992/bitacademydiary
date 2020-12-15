package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			String data = null;
			while(true) {
				//5. 데이터 읽기
				String line = br.readLine();
				System.out.println("[server] line : " + line);
				
				if(line == null){
					// client가 소켓을 정상 종료
					consoleLog("[server] closed by client");
					break;
				}
				
				// request Header의 첫번재 라인만 읽음
				if(data == null) {
					data = line;
					break;
				}
			}
				
				System.out.println("[server] received:" + data);
				
				
				String[] tokens = data.split( " " );
				
				if("GET".equals(tokens[0])) {
					responseStaticResource(outputStream, tokens[1], tokens[2]);
				} else { 
					
					 response400Error( outputStream, tokens[2] );
				     return;
					
					
					// POST, DELETE, PUT, HEAD, CONNECT
					 // HTTP/1.1 400 Bad Request\r\n
					 // Content-Type:text/html; charset=utf-8\r\n
					 // \r\n
					 // html 에러 문서(./webapp/error/400.html)
					 //response400Error();
				}
				
		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}
	
	public void responseStaticResource(OutputStream outputStream, String uri, String protocol) throws IOException {
		if("/".equals(uri)) {
			uri = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + uri);


		if(!file.exists()) {
			if ( file.exists() == false ) {
			     response404Error( outputStream, protocol );
			     return;
			}
			

			return;
		}
		
		// nio
		Path path = file.toPath();
		byte[] body = Files.readAllBytes( path ); 
		String contentType = Files.probeContentType(file.toPath());

		// response
		outputStream.write((protocol + " 200 OK\r\n").getBytes( "UTF-8" ));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes("UTF-8"));
		outputStream.write(body);
		

		
	}

	private void response400Error(OutputStream outputStream, String protocol) {
		try {
			File file = new File(DOCUMENT_ROOT + "/error/400.html");
			Path path = file.toPath();
			byte[] body = Files.readAllBytes( path ); 
			outputStream.write( ( protocol + " 400 Bad Request\r\n" ).getBytes() );
			outputStream.write( "Content-Type:text/html\r\n".getBytes() );
			outputStream.write( "\r\n".getBytes() ); 
			outputStream.write( body );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void response404Error(OutputStream outputStream, String protocol) {
		try {
			File file = new File(DOCUMENT_ROOT + "/error/404.html");
			Path path = file.toPath();
			byte[] body = Files.readAllBytes( path ); 
			outputStream.write( ( protocol +" 404 File Not Found\r\n").getBytes() );
			outputStream.write( "Content-Type:text/html\r\n".getBytes() );
			outputStream.write( "\r\n".getBytes() ); 
			outputStream.write( body  );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
