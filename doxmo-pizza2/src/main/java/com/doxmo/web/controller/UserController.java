package com.doxmo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doxmo.web.servies.BasketService;
import com.doxmo.web.servies.DxmService;
import com.doxmo.web.servies.DxmService2;
import com.doxmo.web.servies.GetStoreService;
import com.doxmo.web.servies.LoginService;
import com.doxmo.web.servies.LogoutService;


@Controller
public class UserController {
	DxmService2 service2 = null;
	DxmService service1 = null;

	@RequestMapping("/session_test")
	public String session_test(Model model) {
		System.out.println("/session_test");
		return "session_test";
	}	

	@RequestMapping("/logout")
	public String logout(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("/logout");
		model.addAttribute("request", httpServletRequest);

		service1 = new LogoutService();
		service1.excute(model); 
		return "logout";
			
	}

	@RequestMapping("/login_view")
	public String login_view(Model model) {
		System.out.println("/login");
		return "login1";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("/login");
		model.addAttribute("request", httpServletRequest);

		service2 = new LoginService();
		if (service2.excute(model)) 
			return "redirect:prdt_list";
		else
			return "login2";
			
	}
	
	
	@RequestMapping("/login_basket")
	public String login_basket(HttpServletRequest request, Model model) {
		System.out.println("/login_basket");
		
		model.addAttribute("request", request);

		service2 = new LoginService();
		if (service2.excute(model)) {
				service1 = new GetStoreService();
				service1.excute(model);
				return "rcpt_tp";

		} else {
			return "login2";
		}
	}

}



	

