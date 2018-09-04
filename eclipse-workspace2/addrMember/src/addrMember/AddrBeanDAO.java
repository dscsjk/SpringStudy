package addrMember;

import java.sql.*;
import java.util.*;

public class AddrBeanDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1/jspdb?useSSL=false";

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
	
	public ArrayList<AddrBook> getDBList() {
		connectDB();
		ArrayList<AddrBook> datas = new ArrayList<AddrBook>();
	
		String sql = "select * from addrbook order by ab_id";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				AddrBook addrbook = new AddrBook();
				addrbook.setAb_id(rs.getInt("ab_id"));
				addrbook.setAb_name(rs.getString("ab_name"));
				addrbook.setAb_email(rs.getString("ab_email"));
				addrbook.setAb_comdept(rs.getString("ab_comdept"));
				addrbook.setAb_birth(rs.getString("ab_birth"));
				addrbook.setAb_tel(rs.getString("ab_tel"));
				addrbook.setAb_memo(rs.getString("ab_memo"));
				datas.add(addrbook);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnectDB();
		}
		return datas;
	}
	
	public boolean insertDB(AddrBook addrbook) {
		connectDB();
		int i=0;
		try {
			//Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한  Statement준비
			String sql = "insert into addrbook (ab_name, ab_email,ab_comdept,ab_birth,ab_tel,ab_memo) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,addrbook.getAb_name());
			pstmt.setString(2,addrbook.getAb_email());
			pstmt.setString(3,addrbook.getAb_comdept());
			pstmt.setString(4,addrbook.getAb_birth());
			pstmt.setString(5,addrbook.getAb_tel());
			pstmt.setString(6,addrbook.getAb_memo());
			
			//username 값을 입력한 경우 sql문장을 수행.
			if(addrbook.getAb_name() != null) {
				i = pstmt.executeUpdate();
				
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			disconnectDB();
		}
		return true;
	}
	
	public AddrBook editDB(int ab_id) {  
		connectDB();
		AddrBook addrbook = new AddrBook();
	
		String sql = "select * from addrbook where ab_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab_id);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			addrbook.setAb_id(rs.getInt("ab_id"));
			addrbook.setAb_name(rs.getString("ab_name"));
			addrbook.setAb_email(rs.getString("ab_email"));
			addrbook.setAb_comdept(rs.getString("ab_comdept"));
			addrbook.setAb_birth(rs.getString("ab_birth"));
			addrbook.setAb_tel(rs.getString("ab_tel"));
			addrbook.setAb_memo(rs.getString("ab_memo"));
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnectDB();
		}

		return addrbook;
	}
	
	public boolean updateDB(AddrBook addrbook) {
		connectDB();
		int i=0;
		try {
			//Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한  Statement준비
			String sql = "update addrbook set ab_name=?, ab_email=?,ab_comdept=?,ab_birth=?,ab_tel=?,ab_memo=? where ab_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,addrbook.getAb_name()); 
			pstmt.setString(2,addrbook.getAb_email());
			pstmt.setString(3,addrbook.getAb_comdept());
			pstmt.setString(4,addrbook.getAb_birth());
			pstmt.setString(5,addrbook.getAb_tel());
			pstmt.setString(6,addrbook.getAb_memo());
			pstmt.setInt(7,addrbook.getAb_id());
			
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			disconnectDB();
		}
		return true;
	}
	
	public boolean deleteDB(int ab_id) {
		connectDB();
		int i=0;
		String sql = "delete from addrbook where ab_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ab_id);
			i = pstmt.executeUpdate();
			System.out.println("Delete건수 : "+i);
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			disconnectDB();
		}
		return true;
	}
}
