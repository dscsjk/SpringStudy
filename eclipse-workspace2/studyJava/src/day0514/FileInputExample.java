package day0514;

import java.io.*;

public class FileInputExample {

	public static void main(String[] args) throws Exception{

		File dir = new File("C:/Temp/Copy");
		File file1 = new File("C:/Temp/test.png");
		File file2 = new File(dir.getPath()+"/test.png");
		
		if(file1.exists() == false) {
			System.out.println(file1.getName()+" 파일이 존재하지 않습니다.");
		} else {
			if(dir.exists() == false) {dir.mkdirs();}
			if(file2.exists() == false) {file2.createNewFile();}
		
			FileInputStream fis;
			FileOutputStream fos;
	
			fis = new FileInputStream(""+file1.getPath());
			fos = new FileOutputStream(""+file2.getPath());
			
			int data;
			while((data=fis.read())!=-1) {
				fos.write(data);
			}
			fis.close();
			fos.flush();
			fos.close();
		}
	}
}
