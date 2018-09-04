package FileinputStream;

import java.io.FileInputStream;

public class FileInputExample {

	public static void main(String[] args) {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(""+"C:\\Users\\user\\eclipse-workspace\\testCar\\src\\testCar\\testCar.java");
			int data;
			while((data=fis.read())!=-1) {
				//OutputStream으로 1바이트씩 보낸다.
				System.out.write(data);
			}
			fis.close(); //사용한 파일시스템 자원을 반납하고 InputStread을 닫는다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
