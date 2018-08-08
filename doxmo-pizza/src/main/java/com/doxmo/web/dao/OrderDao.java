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
import com.doxmo.web.dto.Dxm07;
import com.doxmo.web.dto.Dxm08;


public class OrderDao {

	DataSource dataSource;
//생성자
	public OrderDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setOrder(Dxm07 Order, ArrayList<Dxm08> OrderList) {
		System.out.println("setOrder()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int rtn=0;

		try {
			conn = dataSource.getConnection();
			String sql;
			sql = "insert into tbl_dxm07 (order_no,u_id,store_cd,tt_pay,pay_tp,rcpt_tp,rcpt_nm,rcpt_tel,rcpt_addr,memo,order_st) "
					+ "	values(?,?,?,?,?,?,?,?,?,?,'01')";
			pstmt = conn.prepareStatement(sql);
			long order_no = System.currentTimeMillis();
			pstmt.setString(1,String.valueOf(order_no));
			pstmt.setString(2,Order.getU_id());
			pstmt.setString(3,Order.getStore_cd());
			pstmt.setLong  (4,Order.getTt_pay());
			pstmt.setString(5,Order.getRcpt_tp());
			pstmt.setString(6,Order.getRcpt_nm());
			pstmt.setString(7,Order.getRcpt_tel());
			pstmt.setString(8,Order.getRcpt_addr());
			pstmt.setString(9,Order.getMemo());
			pstmt.executeUpdate();
			
			for (Dxm08 OrderPrdt : OrderList) {
				try {
					sql = "insert into tbl_dxm08 (order_no, prdt_cd, prdt_sz, order_cnt) "
							+ "	values(?,?,?,?)";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,String.valueOf(order_no));
						pstmt.setString(2,OrderPrdt.getPrdt_cd());
						pstmt.setString(3,OrderPrdt.getPrdt_sz());
						pstmt.setInt  (4,OrderPrdt.getOrder_cnt());
						pstmt.executeUpdate();
	
					} catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(pstmt != null) pstmt.close();
							if(conn != null) conn.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
