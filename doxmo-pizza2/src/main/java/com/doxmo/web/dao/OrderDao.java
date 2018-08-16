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
import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.Dxm07;
import com.doxmo.web.dto.Dxm08;
import com.doxmo.web.dto.OrderList;


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

	// 제품리스트를 가져온다.
	public ArrayList<OrderList> getOrderList(String u_id) {
		System.out.println("getPrdtList()");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<OrderList> datas = new ArrayList<OrderList>();
		OrderList orderList=null;

		try {
//			String query = "select to_char(a.crt_dt,'YYYY.MM.DD') crd_dt, " 
//			+ "decode(a.order_st,'01','방문포장','배달') order_st, " 
//			+ "a.order_no order_no, " 
//			+ "e.prdt_nm || decode(c.prdt_cnt,1,'',' 외 '|| to_char(c.prdt_cnt-1) ||'건') prdt_desc, "
//			+ "to_char(a.tt_pay,'999,999,999') tt_pay, "
//			+ "b.store_nm store_nm, "
//			+ "b.store_tel store_tel, " 
//			+ "decode(a.order_st,'01','결제완료','02','상품준비중','03','상품준비완료','04','배달','') order_st " 
//			+ "from tbl_dxm07 a, tbl_dxm06 b, " 
//			+ "(select order_no, min(rowid) rid, count(*) prdt_cnt from tbl_dxm08 group by order_no) c, " 
//			+ "tbl_dxm08 d, tbl_dxm03 e "
//			+ "where a.u_id= ? "
//			+ "and a.store_cd = b.store_cd "
//			+ "and a.order_no = c.order_no "
//			+ "and c.rid = d.rowid "
//			+ "and d.prdt_cd = e.prdt_cd ";
			
			String query = "select crd_dt, rcpt_st, order_no,  prdt_desc,  tt_pay, store_nm, store_tel, order_st " 
			+ "from v_order_list " 
			+ "where u_id= ? " 
			+ "order by order_no desc ";
		
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList=new OrderList();
				orderList.setCrt_dt(rs.getString(1));
				orderList.setRcpt_tp(rs.getString(2));
				orderList.setOrder_no(rs.getString(3));
				orderList.setOrder_prdt(rs.getString(4));
				orderList.setTt_pay(rs.getString(5));
				orderList.setStore_nm(rs.getString(6));
				orderList.setStore_tel(rs.getString(7));
				orderList.setOrder_st(rs.getString(8));
				
				datas.add(orderList);
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

	public Boolean setOrder(Dxm07 Order, ArrayList<Dxm08> OrderList) {
		System.out.println("setOrder()");

		Boolean rtn = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

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
			pstmt.setString(5,Order.getPay_tp());
			pstmt.setString(6,Order.getRcpt_tp());
			pstmt.setString(7,Order.getRcpt_nm());
			pstmt.setString(8,Order.getRcpt_tel());
			pstmt.setString(9,Order.getRcpt_addr());
			pstmt.setString(10,Order.getMemo());
/*			
			System.out.println(String.valueOf(order_no));
			System.out.println(Order.getU_id());
			System.out.println(Order.getStore_cd());
			System.out.println(Order.getTt_pay());
			System.out.println(Order.getRcpt_tp());
			System.out.println(Order.getRcpt_nm());
			System.out.println(Order.getRcpt_tel());
			System.out.println(Order.getRcpt_addr());
			System.out.println(Order.getMemo());
*/
			
			pstmt.executeUpdate();
			try {
				for (Dxm08 OrderPrdt : OrderList) {
						sql = "insert into tbl_dxm08 (order_no, prdt_cd, prdt_sz, order_cnt) "
								+ "	values(?,?,?,?)";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1,String.valueOf(order_no));
							pstmt.setString(2,OrderPrdt.getPrdt_cd());
							pstmt.setString(3,OrderPrdt.getPrdt_sz());
							pstmt.setInt  (4,OrderPrdt.getOrder_cnt());
							pstmt.executeUpdate();
				}
				rtn = true;
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
		return rtn;
	}
}
