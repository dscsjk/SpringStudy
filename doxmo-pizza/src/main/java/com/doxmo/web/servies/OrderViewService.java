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
import com.doxmo.web.dto.RcptTp;
import com.doxmo.web.dto.User;

public class OrderViewService implements DxmService  {

	@Override
	public void excute(Model model) {
		System.out.println("BaketViewService()");
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		OrderList order = new OrderList();
		
		
		HttpSession session = request.getSession();
		RcptTp rcptTp = (RcptTp) session.getAttribute("RcptTp");
		if (rcptTp != null) 
			model.addAttribute("RcptTp", rcptTp);

		User user = (User) session.getAttribute("User");
		if (user != null)
			model.addAttribute("User", user);

		ArrayList<OrderList> orderList = (ArrayList<OrderList>) session.getAttribute("OrderList");
		if (orderList != null)
			model.addAttribute("OrderList", orderList);
	}
}
