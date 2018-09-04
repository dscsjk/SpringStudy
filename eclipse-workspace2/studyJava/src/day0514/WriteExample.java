package day0514;

import java.io.*;

public class WriteExample {

	public static void main(String[] args) throws Exception {
		FileReader fs = new FileReader("C:/Temp/test.txt");
		
		BufferedReader br = new BufferedReader(fs);
		
		FileWriter os = new FileWriter("C:/Temp/test1.txt");
		
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
		fs.close();
		os.close();
	}
}
