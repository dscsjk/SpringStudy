package day0514;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {

	public static void main(String[] args) throws Exception {
		System.out.println(File.separator);
		File dir = new File("C:/Users/Public/Dir");
//		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Users/Public/file1.txt");
		File file2 = new File("C:/Users/Public/file2.txt");
		File file3 = new File(new URI("file:///C:/Users/Public/file3.txt"));
		
		System.out.println(dir.exists());
		System.out.println(file1.exists());
		System.out.println(file2.exists());
		System.out.println(file3.exists());
		
		
		if(dir.exists() == false) {dir.mkdirs();}
		
		if(file1.exists() == false) {file1.createNewFile();}
		if(file2.exists() == false) {file2.createNewFile();}
		if(file3.exists() == false) {file3.createNewFile();}
		
		System.out.println(dir.exists());
		System.out.println(file1.exists());
		System.out.println(file2.exists());
		System.out.println(file3.exists());
		
		File temp = new File("C:/Temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy=mm-dd    a    HH:mm");
		File[] contents = temp.listFiles();
		System.out.println("날짜		시간	형태		크기	이름");
		System.out.println("----------------------------------------------------------");
		for(File file:contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t"+file.getName());
			} else {
				System.out.print("\t\t\t"+file.length()+"\t"+file.getName());
			}
			System.out.println();
		}
	}
}
