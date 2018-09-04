package prj0626;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.*;

//import org.apache.log4j.Logger;
import org.slf4j.*;

public class OrderDAO {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	LogTest lst = new LogTest();
	
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
	
	public ArrayList<Menu> getMenuList() {
		// 메뉴 정보를 가져온다.
		connectDB();
		ArrayList<Menu> datas = new ArrayList<Menu>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from menu");
			lst.LogTest("1.select 결과 ->["+rs.toString()+"]");
			
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setmCd(rs.getString("mcd"));
				menu.setmName(rs.getString("mname"));
				menu.setmPrice(rs.getInt("mprice"));
				// 메뉴정보를 return할 리스트에 추가한다.
				datas.add(menu);
//				System.out.println(menu.getmCd()+menu.getmName()+menu.getmPrice());
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		
		
		return datas;
	}

	public boolean setOderList(ArrayList<OrdList> datas, OrdNum odList ) {
		// 선택메뉴정보를 DB에 insert한다.
		connectDB();
		int i=0;
		
		try {
			// 주문건 insert
			String sql = "insert into orderNum (ordern, uid, tprice) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,odList.getOrderN());
			pstmt.setString(2,odList.getuId());
			pstmt.setInt(3,odList.gettPrice());
			i = pstmt.executeUpdate();
			lst.LogTest("1.insert 결과 ->["+String.valueOf(i)+"]");
			System.out.println("1.주문건 insert갯수 :"+i);
			if ( i > 0 ) {
				// 선택한 메뉴 insert
				sql = "insert into orderlist (ordern, mcd) values (?,?)";
				pstmt = conn.prepareStatement(sql);
				int j=0;
				
				// 선택한 메뉴는 리스트로 넘어오니 for문으로 처리
				for ( OrdList oderN : datas ) {
					System.out.println("주문번호"+odList.getOrderN());
					System.out.println("메뉴코드"+oderN.getmCd());
					
					pstmt.setString(1,odList.getOrderN());
					pstmt.setString(2,oderN.getmCd());
					
					i = pstmt.executeUpdate();
					lst.LogTest("2.insert 결과 ->["+String.valueOf(i)+"]");
					System.out.println("2.주문메뉴 insert건수 :"+i);
					j++;
				}
				System.out.println("3.총 주문메뉴 건수 :"+j);
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			disconnectDB();
		}
		return true;
	}
	
	public ArrayList<OrdList> getOrderList(OrdNum odList) {
		
		// 주문한 정보를 조건에 맞게 가져와 리스트로 만들어 돌려준다.
		connectDB();
		int i=0;
		ArrayList<OrdList> datas = new ArrayList<OrdList>();
		try {
			
			// 조건에 맞게 쿼리 작성
			String sql = "select A.mname mname, A.mprice mprice"
						+ " from menu A, orderlist B, ordernum C"
						+ " where C.ordern = '"+ odList.getOrderN()
//						+ "' and C.uid = '" + odList.getuId()
						+ "' and C.ordern = B.ordern"
						+ " and B.mcd = A.mcd" ;
			
			System.out.println(sql);
			stmt = conn.createStatement();
			
			// select쿼리 실행
			ResultSet rs = stmt.executeQuery(sql);
			lst.LogTest("2.select 결과 ->["+rs.toString()+"]");
			
			// 쿼리 결과를 return할 리스트로 만들어 준다.
			while(rs.next()) {
				OrdList odNum = new OrdList();
				odNum.setmName(rs.getString("mname"));
				odNum.setmPrice(rs.getInt("mprice"));
				datas.add(odNum);

//				System.out.println(odNum.getmName()+odNum.getmPrice());
			}
			
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return datas;
	}
	
}
