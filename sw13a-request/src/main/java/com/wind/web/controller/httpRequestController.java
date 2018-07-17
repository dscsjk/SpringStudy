package com.wind.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class httpRequestController {

	@RequestMapping("/board/confirm_id")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "/board/confirm_id";
	}
	
	@RequestMapping("/board/check_id")
	public String checkId(
						@RequestParam("id") String id, 
						@RequestParam("pw") String pw,
						Model model) {
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "/board/check_id";
	}
	
	@RequestMapping("/member/join")
	public String joinData(
						@RequestParam("id") String id, 
						@RequestParam("pw") String pw,
						@RequestParam("name") String name, 
						@RequestParam("email") String email,
						Model model) {
		Member member = new Member();
		
		member.setId(id);
		member.setEmail(email);
		member.setName(name);
		member.setPw(pw);
		
		model.addAttribute("member",member);
		return "/member/join";
	}
	
	@RequestMapping("/member/joinsimple")
	public String joinDataSimple(Member member) {
		return "/member/join";
	}
	
	@RequestMapping("/member/joinsimple1")
	public String joinDataSimple1(@ModelAttribute("mb") Member member) {
		return "/member/join1";
	}
	
	@RequestMapping("member/{memberId}")
	public String getMemberId(@PathVariable String memberId, Model model) {
		model.addAttribute("memberId",memberId);

		return "member/memberView";
	}

}