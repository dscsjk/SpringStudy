package homework.day0514;

import java.io.*;

public class FileInputExample {

	public static void main(String[] args) throws Exception{
		//2번
		File dir = new File("C:/Temp/Copy");
		File file = new File("C:/Temp/test.png");
		String fName = file.getName();
		
		System.out.println(fName);
		System.out.println(fName.substring(0,fName.indexOf(".")));
		System.out.println(fName.substring(fName.indexOf(".")+1, fName.length()));
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getPath());
		System.out.println(file.pathSeparator);
		
		System.out.println(file.pathSeparatorChar);
		System.out.println(file.separator);
		System.out.println(file.separatorChar);

		//4번
		InputStream is = new FileInputStream("C:/Temp/a.txt");
		OutputStream os = new FileOutputStream("C:/Temp/total.txt");
		byte[] readBytes = new byte[is.available()]; 
		
		readBytes = is.readAllBytes();
		os.write(readBytes);
		is.close();

		is = new FileInputStream("C:/Temp/b.txt");
		readBytes = new byte[is.available()]; 
		readBytes = is.readAllBytes();
		os.write(readBytes);
		is.close();

		is = new FileInputStream("C:/Temp/c.txt");
		readBytes = new byte[is.available()]; 
		readBytes = is.readAllBytes();
		os.write(readBytes);
		is.close();
		
		os.flush();
		os.close();
	}
}
