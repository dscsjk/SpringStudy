package day0517.chatting2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpServer5 {
	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 서버소켓 생성후 5006으로 바인딩
			serverSocket = new ServerSocket(5000);
			System.out.println("연결 기다림.");
			
			// 클라이언트 연결 요청시 통신소켓 생성하고 리턴한다.
			socket = serverSocket.accept();

			Sender sender   = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
} // class

class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;
	BufferedOutputStream bOut ;

	Sender(Socket socket) {
		this.socket = socket;
		try {
			
			bOut = new BufferedOutputStream(socket.getOutputStream());
			out = new DataOutputStream(bOut);
			String address = ""+socket.getInetAddress();
			name = "["+address.substring(1)+":"+socket.getPort()+"]";
		} catch(Exception e) {}
	}

	public void run() {
		Scanner scanner = new Scanner( System.in);

		while(out!=null) {
			try {
				out.writeUTF(name+scanner.nextLine());
			} catch(IOException e) {}
		}
	} // run()
}

class Receiver extends Thread {
	Socket socket;
	DataInputStream in;
	BufferedInputStream bIn;

	Receiver(Socket socket) {
		this.socket = socket;
		try {
			bIn = new BufferedInputStream(socket.getInputStream());
			in = new DataInputStream(bIn);
			
		
		} catch(IOException e) {}

	}

	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			} catch(IOException e) {}
		}
	} // run
}
