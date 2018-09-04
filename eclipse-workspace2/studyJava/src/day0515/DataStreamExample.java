package day0515;

import java.io.*;

public class DataStreamExample {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/Temp/primitive.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		dos.writeDouble(59.5);
		dos.writeInt(1);
		
		dos.writeUTF("김자바");
		dos.writeDouble(90.3);
		dos.writeInt(2);
		
		dos.flush(); dos.close(); fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/Primitive.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		for(int i =0; i<2;i++) {
//		while(true) {
			String name = dis.readUTF();
	//		if (name== null) break; 
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name+" "+score+" "+order);
		}
		
		dis.close(); fis.close();
	}
}
