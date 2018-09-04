package FileinputStream;

import java.io.*;

public class ReadExample2 {

	public static void main(String[] args) throws Exception {
	InputStream is = new FileInputStream("C:/Temp/테스트.txt");
	int readByteNo;
	byte[] readBytes = new byte[2]; // 10������������ ������������.
	String data = "";
	while(true) {
		readByteNo = is.read(readBytes);
		if(readByteNo == -1) break;
		data += new String(readBytes,0,readByteNo);
	}
	System.out.println(data);
	is.close();
	}
}
