package doxmo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DoxMoDAO {

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
		System.out.println("DBMS Connect");
	}
	
	void disconnectDB() {
		try {
			if (conn != null) 
				conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		} 
		System.out.println("DBMS close");
	}

	
	
	public ArrayList<StoreList> getDBList() {
		System.out.println("getDBList()");
		connectDB();
		
		ArrayList<StoreList> datas = new ArrayList<StoreList>();
		
		//String sql="select * from StoreList where valid = 'T' order by store_no desc";
		String sql="select * from StoreList order by store_no desc";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				StoreList storelist = new StoreList();
				
				storelist.setStoreNo(rs.getInt("store_no"));
				storelist.setStorename(rs.getString("store_name"));
				storelist.setAddress(rs.getString("address"));
				storelist.setTel(rs.getString("tel"));
				datas.add(storelist);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			     disconnectDB();
		}
		return datas;
	}

	public boolean getCheckUser(String uId, String pswd) {

		boolean chkPswd = false;
		connectDB();
		System.out.println("getCheckUser()");

		try {
			String sql = "select u_name from tbl_dxm01 where u_id = ? and pswd = sha2(?,256)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,uId);
			pstmt.setString(2,pswd);

			ResultSet rs = pstmt.executeQuery(sql);
			
			rs.next();
			if ( rs.getInt("cnt") > 0 )
				chkPswd = true;
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		
		return chkPswd;
	}

	public Dxm01 getUserInfo(String uId, String pswd, int tp) {

		connectDB();
		System.out.println("getUserInfo()");
		Dxm01 dmx01 = new Dxm01();

		try {
			String sql;
			if ( tp > 0 ) {
				sql = "select * from tbl_dxm01 where u_id = ? )";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,uId);
			} else {
				sql = "select * from tbl_dxm01 where u_id = ? and pswd = sha2(?,256)";
			//	sql = "select * from tbl_dxm01 where u_id = ? and pswd = ?";
				
				System.out.println("udd->"+uId+"pswd->"+pswd);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,uId);
				pstmt.setString(2,pswd);
				System.out.println("sql->"+sql);
			}

			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			dmx01.setU_id(rs.getString("u_id"));
			dmx01.setU_name(rs.getString("u_name"));
			dmx01.setU_tel(rs.getString("u_tel"));
			dmx01.setU_zip(rs.getString("u_zip"));
			dmx01.setU_addr(rs.getString("u_addr"));
			dmx01.setPswd(rs.getString("pswd"));
			dmx01.setUpdt_dt(rs.getString("upd_dt"));
			dmx01.setCrd_dt(rs.getString("crt_dt"));
			System.out.println(dmx01.toString());
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		
		return dmx01;
	}

	// 제품정보를 가져온다.
	public Dxm03 getPrdtInfo(String prdt_cd) {
		connectDB();
		System.out.println("getPrdtInfo()");
		
		Dxm03 dxm03 = new Dxm03();

		try {
			
			System.out.println("select * from tbl_dxm03 where prdt_cd = '"+prdt_cd+"'");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_dxm03 where prdt_cd = '"+prdt_cd+"'");
			
			rs.next();
			dxm03.setPrdt_cd(rs.getString("prdt_cd"));
			dxm03.setPrdt_nm(rs.getString("prdt_nm"));
			dxm03.setPrdt_tp(rs.getString("prdt_tp"));
			dxm03.setPrdt_img(rs.getString("prdt_img"));
			dxm03.setValid(rs.getString("valid"));
			dxm03.setUpd_dt(rs.getString("upd_dt"));
			dxm03.setCrt_dt(rs.getString("crt_dt"));
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return dxm03;
	}

	
	// 제품리스트를 가져온다.
	public ArrayList<Dxm03> getPrdtList(String tp) {
		connectDB();

		System.out.println("getPrdtList()");
		ArrayList<Dxm03> datas = new ArrayList<Dxm03>();
		try {
			
			System.out.println("select * from tbl_dxm03 where valid = 'T' and prdt_tp = '"+tp+"'");

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_dxm03 where valid = 'T' and prdt_tp = '"+tp+"'");
			
			
			while(rs.next()) {
				Dxm03 dxm03 = new Dxm03();
				dxm03.setPrdt_cd(rs.getString("prdt_cd"));
				dxm03.setPrdt_nm(rs.getString("prdt_nm"));
				dxm03.setPrdt_tp(rs.getString("prdt_tp"));
				dxm03.setPrdt_img(rs.getString("prdt_img"));
				dxm03.setValid(rs.getString("valid"));
				dxm03.setUpd_dt(rs.getString("upd_dt"));
				dxm03.setCrt_dt(rs.getString("crt_dt"));
				datas.add(dxm03);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return datas;
	}

	// 제품종류별 가격 리스트를 가져온다.
	public ArrayList<Dxm04> getPriceList(String prdt_cd) {
		connectDB();
		ArrayList<Dxm04> datas = new ArrayList<Dxm04>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_dxm04 where valid = 'T' and prdt_cd = '"+prdt_cd+"'");

			
			while(rs.next()) {
				Dxm04 dxm04 = new Dxm04();
				dxm04.setPrdt_cd(rs.getString("prdt_cd"));
				dxm04.setPrdt_sz(rs.getString("prdt_sz"));
				dxm04.setPrice(rs.getInt("price"));
				dxm04.setValid(rs.getString("valid"));
				dxm04.setCrt_dt(rs.getString("crt_dt"));
				datas.add(dxm04);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return datas;
	}
	
	// 제품 상세정보를 가져온다.
	public Dxm05 getPrdtDetail(String prdt_cd) {
		connectDB();
		Dxm05 dxm05 = new Dxm05();

		try {
			
			System.out.println("select * from tbl_dxm05 where prdt_cd = '"+prdt_cd+"'");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_dxm05 where prdt_cd = '"+prdt_cd+"'");
			
			rs.next();
			dxm05.setPrdt_cd(rs.getString("prdt_cd"));
			dxm05.setPrdt_exp(rs.getString("prdt_exp"));
			dxm05.setPrdt_origin(rs.getString("prdt_origin"));
			dxm05.setPrdt_toping(rs.getString("prdt_toping"));
			dxm05.setUpd_dt(rs.getString("upd_dt"));
			dxm05.setCrt_dt(rs.getString("crt_dt"));
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return dxm05;
	}

	// 제품영양정보 리스트를 가져온다.
	public ArrayList<Dxm15> getNutrientList(String prdt_cd) {
		connectDB();
		
		ArrayList<Dxm15> datas = new ArrayList<Dxm15>();
		try {
			
			String sql ="select A.prdt_nm, B.tt_weight, B.once_piece, B.once_weight, B.calorie, B.protein, B.fat, B.sodium, B.sugar "
			          + "from tbl_dxm03 A, tbl_dxm15 B "
					  + "where A.Valid = 'T' "
			          + "and A.prdt_cd = B.prdt_cd "
					  + "and A.prdt_cd = '"+prdt_cd+"' ";

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
					
			
			
			while(rs.next()) {
				Dxm15 dxm15 = new Dxm15();
				dxm15.setPrdt_nm(rs.getString("prdt_nm"));
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
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return datas;
	}

	// 매장 정보를 가져온다.
	public ArrayList<Dxm06> getStoreList() {
		connectDB();
		
		ArrayList<Dxm06> datas = new ArrayList<Dxm06>();
		try {
			
			String sql ="select * from tbl_dxm06 where valid = 'T' ";

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
					
			while(rs.next()) {
				Dxm06 dxm06 = new Dxm06();
				
				dxm06.setStore_cd(rs.getString("store_cd"));
				dxm06.setStore_nm(rs.getString("store_nm"));
				dxm06.setStore_tel(rs.getString("store_tel"));
				dxm06.setStore_zip(rs.getString("store_zip"));
				dxm06.setStore_addr(rs.getString("store_addr"));
				dxm06.setVaild(rs.getString("valid"));
				dxm06.setUpd_dt(rs.getString("upd_dt"));
				dxm06.setCrt_dt(rs.getString("crt_dt"));
				datas.add(dxm06);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		return datas;
	}	
	
	public boolean setOderList(Dxm07 dxm07, ArrayList<Dxm08> dxm08List  ) {
		// 선택메뉴정보를 DB에 insert한다.
		connectDB();
		int i=0;
		
		try {
			// 주문건 insert
			String sql = "insert into tbl_dxm07 values (?,?,?,?,?,?,?,?,?,?,date(),date())";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dxm07.getOrder_no());
			pstmt.setString(2, dxm07.getU_id());
			pstmt.setInt(3, dxm07.getTt_pay());
			pstmt.setString(4, dxm07.getPay_tp());
			pstmt.setString(5, dxm07.getRcpt_tp());
			pstmt.setString(6, dxm07.getRcpt_nm());
			pstmt.setString(7, dxm07.getRcpt_tel());
			pstmt.setString(8, dxm07.getRcpt_addr());
			pstmt.setString(9, dxm07.getMemo());
			pstmt.setString(10, dxm07.getOrder_st());
			i = pstmt.executeUpdate();
			
			System.out.println("1.주문건 insert갯수 :"+i);
			if ( i > 0 ) {
				// 선택한 메뉴 insert
				
				sql = "insert into tbl_dxm08 values (?,?,date())";
				pstmt = conn.prepareStatement(sql);
				int j=0;
				
				// 선택한 메뉴는 리스트로 넘어오니 for문으로 처리
				for ( Dxm08 dxm08 : dxm08List ) {
					
					pstmt.setString(1,dxm08.getOrder_no());
					pstmt.setString(2,dxm08.getPrdt_cd());
					
					i = pstmt.executeUpdate();
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


	// 매장 정보를 가져온다.
	public ArrayList<Dxm17> getOrderList() {
		connectDB();
		
		ArrayList<Dxm17> datas = new ArrayList<Dxm17>();
		/*
		try {
			
			String sql ="select A.crt_dt, A.crpt_dp, A.order_no, " 
							+ " A.tt_pay, C.store_nm, C.store_tel, A.order_st "
							+ "from tbl_dxm07 A, tbl_dxm06 C "
							+ " where A.user_id = ?"
							+ ""
							
							/*
			" (select prdt_nm from tbl_dxm08 E, tbl_dxm03 D where D.prdt_cd = E.prdt_cd and  @rownum = 1 and E.u_id = '"+u_id+"' ) ||"
			 " '외'  ||"
			" (select count(*)-1 from tbl_dxm08 where order_no = '"+order_no+"' "+" ) || '건' , " 
 
			and A.store_cd = C.store_cd
			order by order_no desc;
			

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
					
			while(rs.next()) {
				Dxm06 dxm06 = new Dxm06();
				
				dxm06.setStore_cd(rs.getString("store_cd"));
				dxm06.setStore_nm(rs.getString("store_nm"));
				dxm06.setStore_tel(rs.getString("store_tel"));
				dxm06.setStore_zip(rs.getString("store_zip"));
				dxm06.setStore_addr(rs.getString("store_addr"));
				dxm06.setVaild(rs.getString("valid"));
				dxm06.setUpd_dt(rs.getString("upd_dt"));
				dxm06.setCrt_dt(rs.getString("crt_dt"));
				datas.add(dxm06);
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			disconnectDB();
		}
		*/
		return datas;
	}	

}
