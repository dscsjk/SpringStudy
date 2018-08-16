package com.doxmo.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.doxmo.web.dto.Dxm01;


public class LoginDao {

	DataSource dataSource;
//생성자
	public LoginDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Dxm01 getUserInfo(String uId, String pswd, int tp) {
		System.out.println("getUserInfo()");
		Dxm01 dmx01 = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql;
			if ( tp == 1 ) {
				System.out.println("1.로그인의 패스워드 확인"+uId+pswd);
				sql = "select * from tbl_dxm01 where u_id = ? and pswd = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,uId);
				pstmt.setString(2,pswd);
			} else {
				System.out.println("2.user정보 가져옴"+uId);
				sql = "select * from tbl_dxm01 where u_id = ? )";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,uId);
			}
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dmx01 = new Dxm01();
				dmx01.setU_id(rs.getString("u_id"));
				dmx01.setU_name(rs.getString("u_name"));
				dmx01.setU_tel(rs.getString("u_tel"));
				dmx01.setU_zip(rs.getString("u_zip"));
				dmx01.setU_addr(rs.getString("u_addr"));
				dmx01.setPswd(rs.getString("pswd"));
				dmx01.setUpdt_dt(rs.getString("upd_dt"));
				dmx01.setCrd_dt(rs.getString("crt_dt"));
				System.out.println(dmx01.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dmx01;
	}

}
