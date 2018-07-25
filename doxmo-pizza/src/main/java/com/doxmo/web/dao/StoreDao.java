package com.doxmo.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.Dxm06;


public class StoreDao {

	DataSource dataSource;
	public StoreDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*	
	public ArrayList<Dxm06> getStoreList() {
		System.out.println("getStoreList()");

		ArrayList<Dxm06> dtos = new ArrayList<Dxm06>();
		Dxm06 dxm06;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String query = "select * from tbl_dxm06 where valid = 'T' ";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				dxm06 = new Dxm06();
				dxm06.setStore_cd(rs.getString("Store_cd"));
				dxm06.setStore_nm(rs.getString("Store_nm"));
				dxm06.setStore_tel(rs.getString("Store_tel"));
				dxm06.setStore_zip(rs.getString("Store_zip"));
				dxm06.setStore_addr(rs.getString("Store_addr"));
				dxm06.setVaild(rs.getString("valid"));
				dxm06.setUpd_dt(rs.getString("upd_dt"));
				dxm06.setCrt_dt(rs.getString("crt_dt"));
				System.out.println(dxm06.toString());
				dtos.add(dxm06);
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
		return dtos;
	}

	*/
	
	public ArrayList<Dxm06> getStoreList() {
		System.out.println("getStoreList()");
		ArrayList<Dxm06> dtos = new ArrayList<Dxm06>();
		Dxm06 dxm06;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select store_cd, store_nm, store_tel, store_zip, store_addr, valid, upd_dt, crt_dt from tbl_dxm06 where valid = 'T' order by store_nm";
			
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				dxm06 = new Dxm06();
				dxm06.setStore_cd(resultSet.getString("store_cd"));
				dxm06.setStore_nm(resultSet.getString("store_nm"));
				dxm06.setStore_tel(resultSet.getString("store_tel"));
				dxm06.setStore_zip(resultSet.getString("store_zip"));
				dxm06.setStore_addr(resultSet.getString("store_addr"));
				dxm06.setVaild(resultSet.getString("valid"));
				dxm06.setUpd_dt(resultSet.getString("upd_dt"));
				dxm06.setCrt_dt(resultSet.getString("crt_dt"));
				System.out.println(dxm06.toString());
				dtos.add(dxm06);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return dtos;
	}
	
	
	
	
	
	// 제품리스트를 가져온다.
	public ArrayList<Dxm03> getPrdtList(String tp) {

		System.out.println("getPrdtList()");
		ArrayList<Dxm03> datas = new ArrayList<Dxm03>();
		Dxm03 dxm03;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String query = "select * from tbl_dxm03 where valid = 'T' and prdt_tp = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tp);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dxm03 = new Dxm03();
				dxm03.setPrdt_cd(rs.getString("prdt_cd"));
				dxm03.setPrdt_nm(rs.getString("prdt_nm"));
				dxm03.setPrdt_tp(rs.getString("prdt_tp"));
				dxm03.setPrdt_img(rs.getString("prdt_img"));
				dxm03.setValid(rs.getString("valid"));
				dxm03.setUpd_dt(rs.getString("upd_dt"));
				dxm03.setCrt_dt(rs.getString("crt_dt"));
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
}	
