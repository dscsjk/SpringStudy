package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.doxmo.web.dto.Dxm07;
import com.doxmo.web.dto.Dxm08;
import com.doxmo.web.dto.OrderList;
import com.doxmo.web.dto.RcptTp;
import com.doxmo.web.dto.User;

public class OrderService implements DxmService {

	@Override
	public void excute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		Dxm07 order = new Dxm07();
		ArrayList<Dxm08> prdtList = new ArrayList<Dxm08>();
		OrderList orderList = new OrderList();
		
		RcptTp rcptTp = (RcptTp) session.getAttribute("RcptTp");
		
		
		if (rcptTp != null) 
			model.addAttribute("RcptTp", rcptTp);

		User user = (User) session.getAttribute("User");
		if (user != null)
			model.addAttribute("User", user);
/*
		ArrayList<OrderList> orderList = (ArrayList<OrderList>) session.getAttribute("OrderList");
		
		OrderDao orderDao = new OrderDao();
		orderDao.setOrder(order, orderList);
		model.addAttribute("prdtNutri", dxm15);
		*/
	}
}
