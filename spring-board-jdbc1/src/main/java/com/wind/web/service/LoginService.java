package com.wind.web.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.wind.web.dao.LoginDao;
import com.wind.web.dto.Dxm01;
import com.wind.web.dto.User;


public class LoginService implements BService  {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String u_id = request.getParameter("userId");
		String pswd = request.getParameter("userPswd");
		System.out.println("uid:"+u_id+" pswd:"+pswd);
		// 로그인 정보 확인하고 값을 가져온다.
		LoginDao dao= new LoginDao();
		Dxm01 dxm01 = dao.getUserInfo(u_id, pswd, 1);
		model.addAttribute("login_view", dxm01);
	
		// 로그인 정보 존재시 세션에 User값을 설정한다. 
		if (dxm01 != null) {		
		// 로그인 정보 존재시 세션에 User값을 설정한다. 
		User user = new User();
		user.setU_id(dxm01.getU_id());
		user.setU_name(dxm01.getU_name());
		user.setU_tel(dxm01.getU_tel());
		
		HttpSession session = request.getSession(true);
		session.setAttribute("User", user);
		}
		
	}
}
