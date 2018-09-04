package day0515;

import java.io.*;

public class BufferdStreamExample {

	public static void main(String[] args) throws Exception {

		FileInputStream fr = new FileInputStream("C:/Temp/image.png");
		long start = System.currentTimeMillis();
		while(fr.read()!=-1) {}
		long end = System.currentTimeMillis();
		System.out.println("그냥 읽기 : "+ (long)(end-start));
		fr.close();

		fr = new FileInputStream("C:/Temp/image.png");
		BufferedInputStream bi = new BufferedInputStream(fr);
		start = System.currentTimeMillis();
		while(bi.read() !=-1) {}
		end = System.currentTimeMillis();
		System.out.println("버퍼로 읽기 : " + (long)(end-start));
		fr.close();
	}

}
