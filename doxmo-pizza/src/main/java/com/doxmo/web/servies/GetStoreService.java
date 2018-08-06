package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.doxmo.web.dao.LoginDao;
import com.doxmo.web.dao.StoreDao;
import com.doxmo.web.dto.Dxm01;
import com.doxmo.web.dto.Dxm06;
import com.doxmo.web.dto.OrderList;
import com.doxmo.web.dto.User;

public class GetStoreService implements DxmService  {

	@Override
	public void excute(Model model) {
		System.out.println("GetStoreService()");
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		OrderList order = new OrderList();
		
		// 로그인전의 주문상품을 넘긴다.
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		String prdt_sz=request.getParameter("prdt_sz");
		
//		order.setPrdt_sz(request.getParameter("prdt_sz"));
//		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setPrdt_sz(prdt_sz.substring(0, 1));
		order.setPrice(Integer.parseInt(prdt_sz.substring(2)));
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		
		model.addAttribute("Order", order);
		
		StoreDao dao= new StoreDao();
		ArrayList<Dxm06> dtos = dao.getStoreList();
		model.addAttribute("RcptTpList", dtos);
	}
}
