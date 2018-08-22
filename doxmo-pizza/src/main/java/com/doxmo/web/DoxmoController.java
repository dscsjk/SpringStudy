package com.doxmo.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doxmo.web.dao.DxmDao;
import com.doxmo.web.dto.Dxm03;

@Controller
public class DoxmoController {

	@Autowired
	private SqlSession sqlSession;
	
	// 트랜잭션 처리
//	@Autowired
//	private DataSourceTransactionManager transactionManager;
	
	@RequestMapping("/prdt_list")
	public String prdt_list(HttpServletRequest request, Model model) {
		String prdt_tp = null;
		prdt_tp = request.getParameter("prdt_tp");
		if ( prdt_tp == null) prdt_tp = "01";
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("dxm03",dxmDao.PrdtListDao(prdt_tp));
		model.addAttribute("prdt_tp",prdt_tp);
		return "prdt_list";
	}

}
