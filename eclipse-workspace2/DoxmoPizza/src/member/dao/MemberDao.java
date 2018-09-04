package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Dxm01;

public class MemberDao {

	public Dxm01 getUserInfo(Connection conn, String uId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from tbl_dxm01 where u_id = ?");
			
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			Dxm01 dxm01 = null;
			if (rs.next()) {
				dxm01 = new Dxm01();
				
				dxm01.setU_id(rs.getString("u_id"));
				dxm01.setU_name(rs.getString("u_name"));
				dxm01.setU_tel(rs.getString("u_tel"));
				dxm01.setU_zip(rs.getString("u_zip"));
				dxm01.setU_addr(rs.getString("u_addr"));
				dxm01.setPswd(rs.getString("pswd"));
				dxm01.setUpdt_dt(rs.getString("upd_dt"));
				dxm01.setCrd_dt(rs.getString("crt_dt"));
				System.out.println(dxm01.toString());
			}
			return dxm01;
		} finally {
			rs.close();
			pstmt.close();
		}
	}

	public Dxm01 getCheckUser(Connection conn, String uId, String pswd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from tbl_dxm01 where u_id = ? and pswd = sha2(?,256)");
			
			pstmt.setString(1, uId);
			pstmt.setString(2, pswd);
			rs = pstmt.executeQuery();
			Dxm01 dxm01 = null;
			if (rs.next()) {
				dxm01 = new Dxm01();
				
				dxm01.setU_id(rs.getString("u_id"));
				dxm01.setU_name(rs.getString("u_name"));
				dxm01.setU_tel(rs.getString("u_tel"));
				dxm01.setU_zip(rs.getString("u_zip"));
				dxm01.setU_addr(rs.getString("u_addr"));
				dxm01.setPswd(rs.getString("pswd"));
				dxm01.setUpdt_dt(rs.getString("upd_dt"));
				dxm01.setCrd_dt(rs.getString("crt_dt"));
				System.out.println(dxm01.toString());
			}
			return dxm01;
		} finally {
			rs.close();
			pstmt.close();
		}
	}

/*	
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into member values(?,?,?,?)")) {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set name = ?, password = ? where memberid = ?")) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		}
	}
*/	
}
