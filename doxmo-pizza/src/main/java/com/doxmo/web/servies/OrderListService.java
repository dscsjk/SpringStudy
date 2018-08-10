package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.doxmo.web.dao.OrderDao;
import com.doxmo.web.dto.OrderList;
import com.doxmo.web.dto.User;

public class OrderListService implements DxmService {

	@Override
	public void excute(Model model) {
		System.out.println("OrderListService()");
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		// 세션 정보 추출
		User sUser = (User) session.getAttribute("User");
		
		OrderDao orderDao = new OrderDao();
		ArrayList<OrderList> orderList = orderDao.getOrderList(sUser.getU_id());
		model.addAttribute("orderList", orderList);
	}
}
