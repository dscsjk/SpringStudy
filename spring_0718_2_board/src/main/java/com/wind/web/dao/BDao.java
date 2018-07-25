package com.wind.web.dao;

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


import com.wind.web.dto.BDto;

public class BDao {

	DataSource dataSource;
//생성자
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos= new ArrayList<BDto>();
		BDto dto;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup,bStep, bIndent"
					+" from mvc_board order by bGroup desc, bStep asc";
			
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				dto = new BDto(resultSet.getInt("bId"), 
						resultSet.getString("bName"),
						resultSet.getString("bTitle"), 
						resultSet.getString("bContent"), 
						resultSet.getTimestamp("bDate"), 
						resultSet.getInt("bHit"), 
						resultSet.getInt("bGroup"),
						resultSet.getInt("bStep"),
						resultSet.getInt("bIndent"));
				dtos.add(dto);
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
	
	public BDto contentView(String strID) {
		upHit(strID);
		
		BDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "select * from mvc_board where bId = ?";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				dto = new BDto(resultSet.getInt("bId"), 
						resultSet.getString("bName"),
						resultSet.getString("bTitle"), 
						resultSet.getString("bContent"), 
						resultSet.getTimestamp("bDate"), 
						resultSet.getInt("bHit"), 
						resultSet.getInt("bGroup"),
						resultSet.getInt("bStep"),
						resultSet.getInt("bIndent"));
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
		
		return dto;
	}
	
	public int write(String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rtn=0;
		try {
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
						 + "values (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			
			rtn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rtn;
	}

	public int delete(String bId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rtn=0;
		try {
			String query = "delete from mvc_board where bId = ?";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			
			rtn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rtn;
	}	
	
	public int modify(String bId, String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rtn=0;
		try {
			String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
			
			rtn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rtn;
	}
	
	public BDto replyView(String bId) {
		
		BDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "select * from mvc_board where bId = ?";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				dto = new BDto(resultSet.getInt("bId"), 
						resultSet.getString("bName"),
						"re:"+resultSet.getString("bTitle"), 
						resultSet.getString("bContent"), 
						resultSet.getTimestamp("bDate"), 
						resultSet.getInt("bHit"), 
						resultSet.getInt("bGroup"),
						resultSet.getInt("bStep"),
						resultSet.getInt("bIndent"));
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
		
		return dto;
	}

	public int reply(String bId,String bName,String bTitle,String bContent,String bGroup,String bStep,String bIndent) {
		
		replyShape(bGroup, bStep);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rtn=0;
		try {
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
						 + "values (mvc_board_seq.nextval,?,?,?,?,?,?)";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep)+1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent)+1);
			
			rtn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rtn;
	}	

	public int upHit(String bId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rtn=0;
		try {
			String query = "update mvc_board set bHit = bHit+1 where bId=?";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			//preparedStatement.setInt(1, Integer.parseInt(bId));
			
			rtn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rtn;
	}	
	
	public int replyShape(String strGroup,String strStep) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rtn=0;
		try {
			String query = "update mvc_board set bStep = bStep+1 "
					+ "where bGroup = ? and bStep > ?";
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, strGroup);
			preparedStatement.setString(1, strStep);
			
			rtn = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rtn;
	}	

}
