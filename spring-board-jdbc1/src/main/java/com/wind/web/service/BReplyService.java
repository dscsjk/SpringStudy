package com.wind.web.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.wind.web.dao.BDao;
import com.wind.web.dto.BDto;

public class BReplyService implements BService {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		 
		BDao dao= new BDao();
		int rtn = dao.reply(bId,bName,bTitle, bContent,bGroup,bStep,bIndent);

	}

}
