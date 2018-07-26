package com.wind.web.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.wind.web.dto.TicketDto;

@Repository
public class TicketDao {

	JdbcTemplate template;
	DataSourceTransactionManager transactionManager;
//	PlatformTransactionManager transactionManager;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		
	}
	
	@Autowired
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
//	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
		
	}
	public TicketDao() {
		System.out.println("TicketDao()");
	}

	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("buyTicket()"+ dto.getConsumerId());
		System.out.println("buyTicket()"+ dto.getAmount());
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
				
		try {
			String query = "insert into card (consumerId,amount) values (?,?)";
			template.update(query, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
				    ps.setString(1, dto.getConsumerId());
				    ps.setInt(2, dto.getAmount());
				}
			});
			
			query = "insert into ticket (consumerId,countnum) values (?,?)";
			template.update(query, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
				    ps.setString(1, dto.getConsumerId());
				    ps.setInt(2, dto.getAmount());
				}
			});
			transactionManager.commit(status);
		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
	}
}
