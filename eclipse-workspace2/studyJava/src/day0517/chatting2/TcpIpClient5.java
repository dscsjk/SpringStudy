package day0517.chatting2;

import java.net.*;
import java.io.*;

public class TcpIpClient5 {
	public static void main(String args[]) {
		try {
			String serverIp = "61.41.116.166";
 			Socket socket = new Socket(serverIp, 6000); 

			System.out.println("연결 요청.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {  
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();  
		}  
	} // main
} // class
