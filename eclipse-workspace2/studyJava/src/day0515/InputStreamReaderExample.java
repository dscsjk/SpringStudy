package day0515;

import java.io.*;

public class InputStreamReaderExample {

	public static void main(String[] args) throws Exception {

		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		OutputStream os = new FileOutputStream("c:/Temp/file.txt");
//		OutputStream os = System.out;
		Writer writer = new OutputStreamWriter(os);
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo=reader.read(cbuf))!=-1) {
			String data = new String(cbuf, 0, readCharNo);
			writer.write(data);
			writer.flush();
//			System.out.println(data);
		}
		writer.close();
		reader.close();
	}

}
