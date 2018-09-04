package jvMember;

import java.sql.*;
import java.util.*;

public class JvMemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://61.41.116.178:3306/twitter?useSSL=false";

	void connectDB() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"root","1234");
			
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
		ArrayList<JvMember> datas = new ArrayList<JvMember>();
	
		String sql = "select * from twit order by ab_id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				JvMember jvMember = new JvMember();
				jvMember.setAb_id(rs.getString("ab_id"));
				jvMember.setAb_tdate(rs.getString("ab_tdate"));
				jvMember.setAb_memo(rs.getString("ab_memo"));
				datas.add(jvMember);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnectDB();
		}
		return datas;
	}
}
