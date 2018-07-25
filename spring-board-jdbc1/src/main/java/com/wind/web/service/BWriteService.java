package com.wind.web.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.wind.web.dao.BDao;

public class BWriteService implements BService {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String u_id = request.getParameter("u_id");
		String pswd = request.getParameter("pswd");
		System.out.println("uid:"+u_id+" pswd:"+pswd);
		
		BDao dao= new BDao();
		int rtn = dao.write(bName, bTitle, bContent);
	}
}
