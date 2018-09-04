package jvMember;

import java.sql.*;
import java.util.*;
import jvMember.*;

public class JvMemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://61.41.116.178:3306/twitter?useSSL=false";

	void connectDB() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"testuser","1234");
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}
	
	void disconnectDB() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();;
			}
		}
	}
	
	public ArrayList<JvMember> getDBList() {
		connectDB();
		int i=0;
		ArrayList<JvMember> datas = new ArrayList<JvMember>();
	
		String sql = "select * from twit order by tdate desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				JvMember jvMember = new JvMember();
				jvMember.setAb_id(rs.getString("userid"));
				jvMember.setAb_tdate(rs.getString("tdate"));
				jvMember.setAb_memo(rs.getString("memo"));
				datas.add(jvMember);
				i++;
			}
			System.out.println("select결과 :"+ i);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnectDB();
		}
		return datas;
	}
	
	public boolean insertDB(JvMember jvMember) {
		connectDB();
		int i=0;
		try {
			//Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한  Statement준비
			String sql = "insert into twit (userid, memo, tdate) values (?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,jvMember.getAb_id());
			pstmt.setString(2,jvMember.getAb_memo());
			
			//username 값을 입력한 경우 sql문장을 수행.
			if(jvMember.getAb_id() != null) {
				i = pstmt.executeUpdate();
				System.out.println("insert결과 :"+i);
				
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			disconnectDB();
		}
		return true;
	}

}
