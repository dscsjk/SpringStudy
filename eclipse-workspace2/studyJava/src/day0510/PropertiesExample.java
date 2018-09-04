package day0510;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		try {
			String path = PropertiesExample.class.getResource("test.properties").getPath();
			path = URLDecoder.decode(path,"utf-8");
			properties.load(new FileReader(path));
			
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			
			System.out.println("driver: "+driver);
			System.out.println("url: "+url);
			System.out.println("username: "+username);
			System.out.println("passwrod: "+password);
		} catch (Exception e) {
			System.out.println("프로퍼티 파일이 존재하지 않습니다.");
		}
	}

}
