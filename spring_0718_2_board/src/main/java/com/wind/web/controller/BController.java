package com.wind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wind.web.service.BContentService;
import com.wind.web.service.BDeleteService;
import com.wind.web.service.BListService;
import com.wind.web.service.BModifyService;
import com.wind.web.service.BReplyService;
import com.wind.web.service.BReplyViewService;
import com.wind.web.service.BService;
import com.wind.web.service.BWriteService;
import com.wind.web.service.LoginService;

@Controller
public class BController {
	
	BService service = null;
	
	@RequestMapping("/login_view")
	public String login_view_test(Model model) {

		return "login1";
	}
	@RequestMapping("/login")
	public String login_test(Model model) {
		
		service = new LoginService();
		service.excute(model);
		
		return "prdt_list";
		/*
		else
			return "login2";
			*/
	}

	@RequestMapping("/list")
	public String list(Model model) {
		service = new BListService();
		service.excute(model);
		return "list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("/content_view");
		model.addAttribute("request", httpServletRequest);
		service = new BContentService();
		service.excute(model);
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("/write_view");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		System.out.println("/write");
		model.addAttribute("request", request);
		service = new BWriteService();
		service.excute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("/delete");
		model.addAttribute("request", request);
		service = new BDeleteService();
		service.excute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,Model model) {
		System.out.println("/modify");
		model.addAttribute("request", request);
		service = new BModifyService();
		service.excute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		System.out.println("/reply_view");
		model.addAttribute("request", request);
		service = new BReplyViewService();
		service.excute(model);
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,Model model) {
		System.out.println("/reply");
		model.addAttribute("request", request);
		service = new BReplyService();
		service.excute(model);
		return "redirect:list";
	}
	

}
