package FileinputStream;

import java.io.*;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		byte[] data = "ABC".getBytes();
		/* 한바이트씩 쓰기
		for(int i=0; i< data.length;i++) {
			os.write(data[i]);
		}
		*/
		// 전체쓰기
		os.write(data);
		// 끊어쓰기
		os.write(data,1,2);
		os.flush();
		os.close();
		
		Writer os1 = new FileWriter("C:/Temp/test.txt");
		
		for(int i=0; i<10 ;i++) {
			int data2 = 35;
			String data3 = "";
			data3 = String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%d\n"
					,i, "123456789012"+i,"123456789012"+i, "kim su jung"+i
					,"korea anyang dongan siminstreet "+i+"-"+i,i+"2345678901","ksj"+i+"@naver.com"
					,i+"2345678901","0"+i,i);
			
			os1.write(data3);
			os1.flush();
		}
		os1.close();
		
	}

}
