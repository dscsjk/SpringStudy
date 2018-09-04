package day0516;

import java.io.IOException;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.*;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1.서버 소켓생성
			serverSocket = new ServerSocket();									
			// 2.생성된 서버 소켓에 포트번호 바인딩. 
			// ServerSocket생성시 넣은 포트번호가 다른어플에서 사용시에는 BindException발생.
			serverSocket.bind(new InetSocketAddress("localhost", 5000));   	
			// 만일 서버 ip에 멀티ip가 할당된 경우 특정 ip로 접속시 localhost대신 정확한 ip주소를 대입 

			//3. 클라이언트의 연결요청을 대기하고 있음
			while(true) {
				System.out.print("[연결 기다림]");
				//클라이언트가 연결요청시 통신할 Socket을 생성하고 리턴해준다
				Socket socket = serverSocket.accept();   //올때까지 블록킹
				
				//연결된 클라이언트의 IP와  포트번호정보
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.print("[연결 수락함]"+ isa.getHostName());
				
				//수신 메세지를 대상 클라이언트에 송신
				byte[ ] bytes = null;
				String message = null;
//				InputStream is = socket.getInputStream();
				BufferedInputStream is = new BufferedInputStream(socket.getInputStream());
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("데이타 받기 성공"+ message);
				
//				OutputStream os = socket.getOutputStream();
				BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이타 보내기 성공]");
				
				is.close();
				os.close();
				socket.close();
			}
		} catch(Exception e) { e.printStackTrace();}
			
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {}
		}
	}
}
