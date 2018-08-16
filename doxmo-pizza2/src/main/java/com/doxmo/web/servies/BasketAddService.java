package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.doxmo.web.dao.ProductDao;
import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.OrderPrdt;

public class BasketAddService implements DxmService {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		System.out.println("BasketAddService");
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		OrderPrdt order = new OrderPrdt();
		
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		System.out.println(order.getPrdt_cd());
		
		order.setPrdt_sz(request.getParameter("prdt_sz"));
		System.out.println(order.getPrdt_sz());
		
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		System.out.println(order.getOrder_cnt());
		
		HttpSession session = request.getSession();
		ArrayList<OrderPrdt> orderList = new ArrayList<OrderPrdt>();
		int dupCnt=0;
		// 동일제품코드와 사이즈가 있으면 주문갯수만 더해서 리스트를 업데이트한다.
		for (OrderPrdt isOrder : (ArrayList<OrderPrdt>) session.getAttribute("OrderList")) {
			if (isOrder.getPrdt_cd().equals(order.getPrdt_cd())
			 && isOrder.getPrdt_sz().equals(order.getPrdt_sz())) {
					isOrder.setOrder_cnt(order.getOrder_cnt());
					dupCnt++;
			}
			orderList.add(isOrder);
		}
			
		System.out.println("1.dupCnt"+dupCnt);
			
		session.setAttribute("OrderList", orderList);
	}
}
