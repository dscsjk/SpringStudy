package day0516;

import java.io.*;
import java.net.Socket;

import javafx.application.*;
import javafx.stage.Stage;

import java.net.*;


public class ClientExample extends Application {
	public static void main(String[] args) {
		/*
		Socket socekt = new Socket();
		socket.connect(new InetsocketAddress("61.41.116.166",5002));
*/
		
		Socket socket = null;
		try {
			socket = new Socket();
			System.out.print("[연결 요청]");
			
			socket.connect(new InetSocketAddress("61.41.116.166", 5000));
			
//			Socket socket = new socket(new InetSocketAddress("61.41.116.165", 5007));
			System.out.print("[연결 성공]");
			
			byte[] bytes = null;
			String message = null;
			
			//서버에 Hello Server라는 데이터를 보냄
//			OutputStream os = socket.getOutputStream();
			BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
			
			message = "쉬면서 합시다";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터보내기 성공]");
			
			//서버로부터 데이터를 받음
//			InputStream is = socket.getInputStream();
			BufferedInputStream is = new BufferedInputStream(socket.getInputStream());
			
			bytes = new byte[100];
			//read()호출되면 상대방이 데이터를 보낼때까지 블로킹됨
			//블로킹이 해제되는경우
			//1. 상대방이 데이터를 보내는 경우 int값은 읽은 바이트수
			//2. 상대방이 정상적으로 socket의 close를 호출한경우 리턴값-1
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[데이터받기 성공]" + message);
			
			os.close();
			is.close();
			
		} catch (Exception e) {}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e1) {}
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
