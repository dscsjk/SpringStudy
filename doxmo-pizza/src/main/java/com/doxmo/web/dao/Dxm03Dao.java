package com.doxmo.web.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.Dxm04;


public class Dxm03Dao {

	DataSource dataSource;
	public Dxm03Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Dxm03 getPrdtInfo(String prdt_cd) {
		System.out.println("getPrdtInfo()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dxm03 dxm03 = null;

		try {
			String query = "select * from tbl_dxm03 where prdt_cd = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdt_cd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dxm03 = new Dxm03();
				dxm03.setPrdt_cd(rs.getString("prdt_cd"));
				dxm03.setPrdt_nm(rs.getString("prdt_nm"));
				dxm03.setPrdt_tp(rs.getString("prdt_tp"));
				dxm03.setPrdt_img(rs.getString("prdt_img"));
				dxm03.setValid(rs.getString("valid"));
				dxm03.setUpd_dt(rs.getString("upd_dt"));
				dxm03.setCrt_dt(rs.getString("crt_dt"));
				rs.close();
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
		return dxm03;
	}

	

	// 제품리스트를 가져온다.
	public ArrayList<Dxm03> getPrdtList(String tp) {
		System.out.println("getPrdtList()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Dxm03> datas = new ArrayList<Dxm03>();
		Dxm03 dxm03;

		try {
			String query = "select * from tbl_dxm03 where valid = 'T' and prdt_tp = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tp);
			rs = pstmt.executeQuery();
			ArrayList<Dxm04> dxm04;
			while(rs.next()) {
				dxm03=new Dxm03();
				dxm03.setPrdt_cd(rs.getString("prdt_cd"));
				dxm03.setPrdt_nm(rs.getString("prdt_nm"));
				dxm03.setPrdt_tp(rs.getString("prdt_tp"));
				dxm03.setPrdt_img(rs.getString("prdt_img"));
				dxm03.setValid(rs.getString("valid"));
				dxm03.setUpd_dt(rs.getString("upd_dt"));
				dxm03.setCrt_dt(rs.getString("crt_dt"));
				dxm03.setPrdt_sz(getPriceList(dxm03.getPrdt_cd()));
				datas.add(dxm03);
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
		return datas;
	}
	
	public ArrayList<Dxm04> getPriceList(String prdt_cd) {
		System.out.println("getPriceList()->"+prdt_cd);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Dxm04> datas = new ArrayList<Dxm04>();
		Dxm04 dxm04;
		
		try {
			String query = "select * from tbl_dxm04 where valid = 'T' and prdt_cd = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdt_cd);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				dxm04 = new Dxm04();
				dxm04.setPrdt_cd(rs.getString("prdt_cd"));
				dxm04.setPrdt_sz(rs.getString("prdt_sz"));
				dxm04.setPrice(rs.getInt("price"));
				dxm04.setValid(rs.getString("valid"));
				dxm04.setCrt_dt(rs.getString("crt_dt"));
				datas.add(dxm04);
			}
			rs.close();
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
		return datas;
	}
}	
