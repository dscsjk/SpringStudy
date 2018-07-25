package com.wind.web.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.wind.web.dao.BDao;

public class BDeleteService implements BService {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		
		BDao dao= new BDao();
		int rtn = dao.delete(bId);
	}

}
