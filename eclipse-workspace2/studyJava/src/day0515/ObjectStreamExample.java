package day0515;

import java.io.*;
import java.util.ArrayList;

public class ObjectStreamExample {

	public static void main(String[] args) throws Exception {

		FileOutputStream fos = new FileOutputStream("c:/Temp/UserInfo.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		UserInfo u1 = new UserInfo ("JavaMan","1234",30);
		UserInfo u2 = new UserInfo ("JavaWoman","4321",26);
		
		ArrayList<UserInfo> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		
		oos.writeObject(u1);
		oos.writeObject(u2);
		oos.writeObject(list);
		oos.flush(); oos.close(); 
		//bos.close(); fos.close();
		
		System.out.println("직렬화 종료");
		
		FileInputStream fis = new FileInputStream("c:/Temp/UserInfo.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		UserInfo u3 = (UserInfo) ois.readObject();
		UserInfo u4 = (UserInfo) ois.readObject();
		ArrayList<UserInfo> list1 = (ArrayList<UserInfo>) ois.readObject();
		ois.close(); fis.close();
		
		System.out.println(u3);
		System.out.println(u4);
		
		for( UserInfo u5 : list1) {
			System.out.println(u5);
		}
		System.out.println("역직렬화 종료");
	}

}
