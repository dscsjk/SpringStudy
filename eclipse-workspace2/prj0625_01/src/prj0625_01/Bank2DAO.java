package prj0625_01;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class Bank2DAO {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	void connectDB() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	void disconnectDB() {
		try {
			if (conn != null) 
				conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		} 
		System.out.println("close");
	}
	
	public Account getData() {
		Account account = new Account();
		connectDB();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bank1");
			rs.next();
			account.setAid(rs.getInt("aid"));
			account.setAname(rs.getString("aname"));
			account.setBalance(rs.getInt("balance"));
		} catch (Exception e) {
			System.out.println(account.getAid()+account.getAname()+account.getBalance());
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		
		return account;
	}
	
	public boolean transfer(int bal) {
		connectDB();
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("update bank1 set balance = balance-? where aid = 101");
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("update bank2 set balance = balance-? where aid = 201");
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select balance from bank2 where aid=201");
			rs.next();
			if(rs.getInt(1)>80) {
				conn.rollback();
				return false;
			} else 
				conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return true;
	}
}
