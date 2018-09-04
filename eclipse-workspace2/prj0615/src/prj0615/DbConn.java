package prj0615;

import java.sql.*;

public class DbConn {

	public Connection setDb() {
		Connection conn = null;
		
		// 데이터베이스 연결관련 정보를 문자열로 선언
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb";
		
		try {
			//jdbc 드라이버 로드
			Class.forName(jdbc_driver);
			
			//데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"root","1234");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
