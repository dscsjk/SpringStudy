package com.doxmo.web.servies;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class LogoutService implements DxmService  {

	@Override
	public void excute(Model model) {
		System.out.println("LogoutService()");
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		HttpSession session = request.getSession(true);
		session.removeAttribute("User");
		session.removeAttribute("RcptTp");
		session.removeAttribute("Order");
		session.removeAttribute("OrderList");
		session.invalidate();
	}

}
