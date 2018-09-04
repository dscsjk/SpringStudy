package day0515;

import java.io.*;

public class FileExample {

	public static void main(String[] args) throws Exception {
		File fi = new File("C:/Temp/test2.txt");
		FileReader fr = new FileReader(fi);
		FileWriter os = new FileWriter("C:/Temp/test3.txt");
/*		
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(os);

		String str;
		try {
			while( (str = br.readLine()) != null) {
				System.out.println(str);
				bw.write(str);
				bw.newLine();
			}
		} catch(IOException e){}
		br.close();
		bw.close();
		fr.close();
		os.close();
		*/
	
		System.out.println((int)(fi.length()/2));
		char[] cbuf = new char[(int)fi.length()/2];
		
		int size = fr.read(cbuf);
		os.write(cbuf, 0, size);

		os.write(" 밥 먹구 공부합시다.");
		fr.close();
		os.flush();
		os.close();
	}
}
