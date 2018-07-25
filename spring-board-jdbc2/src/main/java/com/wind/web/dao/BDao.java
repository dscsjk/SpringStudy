package com.wind.web.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.wind.web.dto.BDto;
import com.wind.web.util.Constant;

public class BDao {

	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template=this.template;
		
	}

	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos= null;
		
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup,bStep, bIndent"
					+" from mvc_board order by bGroup desc, bStep asc";
		dtos=(ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		return dtos;

	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		String query = "select * from mvc_board where bId = ?" ;
		return template.queryForObject(query, new Object[] {strID}, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	public int write(final String bName, final String bTitle, final String bContent) {

		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
		 + "values (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			    ps.setString(1, bName);
			    ps.setString(2, bTitle);
			    ps.setString(3, bContent);
			}
	   });
		
	}

	public int delete(final String bId) {
		String query = "delete from mvc_board where bId = ?";
		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			    ps.setString(1, bId);
			}
	   });
	}	
	
	public int modify(final String bId, final String bName, final String bTitle, final String bContent) {
		String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			    ps.setString(1, bId);
			    ps.setString(2, bName);
			    ps.setString(3, bTitle);
			    ps.setString(4, bContent);
			}
	   });

	}
	
	public BDto replyView(String bId) {
		String query = "select * from mvc_board where bId = ?" ;
		return template.queryForObject(query, new Object[] {bId}, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}

	public int reply(final String bId,final String bName,final String bTitle,final String bContent,final String bGroup,final String bStep,final String bIndent) {
		
		String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
		 + "values (mvc_board_seq.nextval,?,?,?,?,?,?)";
		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			    ps.setString(1, bName);
			    ps.setString(2, bTitle);
			    ps.setString(3, bContent);
			    ps.setInt(4, Integer.parseInt(bContent));
			    ps.setInt(5, Integer.parseInt(bStep)+1);
			    ps.setInt(6, Integer.parseInt(bIndent)+1);
			}
	   });

	}	

	public int upHit(final String bId) {
		
		String query = "update mvc_board set bHit = bHit+1 where bId=?";
		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			    ps.setString(1, bId);
			}
		});

	}	
	
	public int replyShape(final String strGroup, final String strStep) {
		
		String query = "update mvc_board set bStep = bStep+1 "
					+ "where bGroup = ? and bStep > ?";
		return template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			    ps.setString(1, strGroup);
			    ps.setString(2, strStep);
			}
		});

	}	
}
