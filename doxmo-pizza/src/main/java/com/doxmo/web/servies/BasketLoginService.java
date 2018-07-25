package com.doxmo.web.servies;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.doxmo.web.dto.OrderList;

public class BasketLoginService implements DxmService  {

	@Override
	public void excute(Model model) {
		System.out.println("BasketLoginService()");
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		OrderList order = new OrderList();
		
		// 로그인전의 주문상품을 넘긴다.
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		order.setPrdt_sz(request.getParameter("prdt_sz"));
		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		
		model.addAttribute("Order", order);
		
	}
}
