package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.doxmo.web.dao.ProductDao;
import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.OrderList;

public class OrderService implements DxmService {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		OrderList order = new OrderList();
		
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		order.setPrdt_sz(request.getParameter("prdt_sz"));
		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		
		HttpSession session = request.getSession();
		session.setAttribute("Order", order);
	}
}
