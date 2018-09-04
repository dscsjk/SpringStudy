package day0516;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴터 IP addr:" + local.getHostAddress());
			
			InetAddress[] isArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : isArr) {
				System.out.println("www.naver.com IP addr: " + remote.getHostAddress());
			}
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
