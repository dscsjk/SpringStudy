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
import com.doxmo.web.dto.Dxm04;
import com.doxmo.web.dto.Dxm05;
import com.doxmo.web.dto.Dxm15;


public class ProductDao {

	DataSource dataSource;
	public ProductDao() {
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
			String query = "select to_char(a.crt_dt,'YYYY.MM.DD')," + 
					"decode(a.order_st,'01','방문포장','배달'), " + 
					"a.order_no, " + 
					"b.store_nm, " + 
					"b.store_tel, " + 
					"decode(a.order_st,'01','결제완료','02','상품준비중','03','상품준비완료','04','배달','')  " + 
					"from tbl_dxm07 a, tbl_dxm06 " + 
					"where a.u_id=? and a.store_cd = b.store_cd  ";
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
		Dxm03 dxm03=null;

		try {
			String query = "select * from tbl_dxm03 where valid = 'T' and prdt_tp = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tp);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dxm03=new Dxm03();
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
	
	public Dxm03 getPrdt(String prdt_cd) {
		System.out.println("getPrdt()");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Dxm03 dxm03=null;

		try {
			String query = "select * from tbl_dxm03 where prdt_cd = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdt_cd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dxm03=new Dxm03();
				dxm03.setPrdt_cd(rs.getString("prdt_cd"));
				dxm03.setPrdt_nm(rs.getString("prdt_nm"));
				dxm03.setPrdt_tp(rs.getString("prdt_tp"));
				dxm03.setPrdt_img(rs.getString("prdt_img"));
				dxm03.setValid(rs.getString("valid"));
				dxm03.setUpd_dt(rs.getString("upd_dt"));
				dxm03.setCrt_dt(rs.getString("crt_dt"));
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

	public ArrayList<Dxm04> getPriceList(String prdt_cd) {
		System.out.println("getPriceList()->"+prdt_cd);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Dxm04> datas = new ArrayList<Dxm04>();
		Dxm04 dxm04=null;
		
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



// 제품 상세정보를 가져온다.
	public Dxm05 getPrdtDetail(String prdt_cd) {
		System.out.println("getPrdtDetail()->"+prdt_cd);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Dxm05 dxm05=null;
	
		try {
			String query = "select * from tbl_dxm05 where prdt_cd = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdt_cd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dxm05 = new Dxm05();
				dxm05.setPrdt_cd(rs.getString("prdt_cd"));
				dxm05.setPrdt_exp(rs.getString("prdt_exp"));
				dxm05.setPrdt_origin(rs.getString("prdt_origin"));
				dxm05.setPrdt_toping(rs.getString("prdt_toping"));
				dxm05.setUpd_dt(rs.getString("upd_dt"));
				dxm05.setCrt_dt(rs.getString("crt_dt"));
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
		return dxm05;
	}

	// 제품영양정보 리스트를 가져온다.
	public ArrayList<Dxm15> getNutrientList(String prdt_cd) {
		System.out.println("getNutrientList()->"+prdt_cd);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Dxm15> datas = new ArrayList<Dxm15>();
		try {
			
			String query = "select A.prdt_nm, B.prdt_sz, B.tt_weight, B.once_piece, B.once_weight, B.calorie, B.protein, B.fat, B.sodium, B.sugar "
			          + "from tbl_dxm03 A, tbl_dxm15 B "
					  + "where A.Valid = 'T' "
			          + "and A.prdt_cd = B.prdt_cd "
					  + "and A.prdt_cd = ? ";
	
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdt_cd);
			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				Dxm15 dxm15 = new Dxm15();
				dxm15.setPrdt_nm(rs.getString("prdt_nm"));
				dxm15.setPrdt_sz(rs.getString("prdt_sz"));
				dxm15.setTt_weight(rs.getInt("tt_weight"));
				dxm15.setOnce_piece(rs.getInt("once_piece"));
				dxm15.setOnce_weight(rs.getInt("once_weight"));
				dxm15.setCalorie(rs.getInt("calorie"));
				dxm15.setProtein(rs.getInt("protein"));
				dxm15.setFat(rs.getInt("fat"));
				dxm15.setSodium(rs.getInt("sodium"));
				dxm15.setSugar(rs.getInt("sugar"));
				datas.add(dxm15);
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

