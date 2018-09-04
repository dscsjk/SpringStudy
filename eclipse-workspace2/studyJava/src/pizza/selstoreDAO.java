package pizza;

import java.sql.*;
import java.util.*;

public class selstoreDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	String jdbc_driver = "com.mysql.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://127.0.0.1:3306/jspdb";
	
	
	public ArrayList<StoreList> getDBList() {
	connect();
		ArrayList<StoreList> datas = new ArrayList<StoreList>();
		
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
			     disconnect();
		}
		return datas;
	}
}

