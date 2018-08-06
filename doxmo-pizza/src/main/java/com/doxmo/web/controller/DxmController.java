package com.doxmo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doxmo.web.servies.BasketLoginService;
import com.doxmo.web.servies.BasketService;
import com.doxmo.web.servies.BasketViewService;
import com.doxmo.web.servies.Dxm03Service;
import com.doxmo.web.servies.DxmService;
import com.doxmo.web.servies.GetStoreService;
import com.doxmo.web.servies.PrdtDetailService;
import com.doxmo.web.servies.RcptTpService;


@Controller
public class DxmController {
	DxmService service = null;

	@RequestMapping("/dxm03")
	public String list(Model model) {
		System.out.println("DxmController:list");

		service = new Dxm03Service();
		service.excute(model);
		return "dxm03";
	}

	@RequestMapping("/basket")
	public String basket(HttpServletRequest request,Model model) {
		System.out.println("/basket");

		HttpSession session = request.getSession(false);
		model.addAttribute("request", request);
		
		// 세션이 존재하지 않으면 login화면으로 가기
		if (session.getAttribute("User") == null) {
			System.out.println(">> User세션 is null");
			
			service = new BasketLoginService();
			service.excute(model);
			
			return "login3";
		} 
		// 주문방법이 존재하지 않으면 세션에 임시로 주문상품 저장하고 주문방법 선택화면으로 가기
		if ( session.getAttribute("RcptTp") == null ) { 
			System.out.println(">> 주문방법 is null");

			service = new GetStoreService();
			service.excute(model);
			
			return "rcpt_tp";
		}
		// 로그인과 주문방법이 존재하면 주문정보를 세션에 담고 제품리스트화면으로 가기
		System.out.println(">> 세션과 주문방법이 존재 ");
		service = new BasketService();
		service.excute(model);
		return "redirect:prdt_list";
	}

	@RequestMapping("/rcpt_tp_list")
	public String rcpt_tp_list( HttpServletRequest request, Model model) {
		System.out.println("/rcpt_tp_list");
		model.addAttribute("request", request);

		service = new GetStoreService();
		service.excute(model); 
		return "rcpt_tp";
	}
	@RequestMapping("/rcpt_tp_choice")
	public String rcpt_tp_choice( HttpServletRequest request, Model model) {
		System.out.println("/rcpt_tp_choice");
		model.addAttribute("request", request);
		service = new RcptTpService();
		service.excute(model); 
		return "redirect:prdt_list";
	}
	
	@RequestMapping("/basket_view")
	public String basket_view( HttpServletRequest request, Model model) {
		System.out.println("/basket_view");
		model.addAttribute("request", request);

		service = new BasketViewService();
		service.excute(model); 
		return "basket";
	}

	@RequestMapping("/prdt_list")
	public String prdet_list( HttpServletRequest request, Model model) {
		System.out.println("/prdt_list");
		model.addAttribute("request", request);
		service = new Dxm03Service();
		service.excute(model); 
		return "prdt_list";
	}
	
	@RequestMapping("/prdt_detail")
	public String prdet_detail( HttpServletRequest request, Model model) {
		System.out.println("/prdt_detail");
		model.addAttribute("request", request);
		service = new PrdtDetailService();
		service.excute(model); 
		return "prdt_detail";
	}

}



	

