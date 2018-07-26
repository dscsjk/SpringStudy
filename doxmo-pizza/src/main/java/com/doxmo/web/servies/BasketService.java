package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.doxmo.web.dao.ProductDao;
import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.OrderList;

public class BasketService implements DxmService {

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
		ArrayList<OrderList> orderList = new ArrayList<OrderList>();
		ArrayList<OrderList> sessionOrderList = (ArrayList<OrderList>) session.getAttribute("OrderList");
		
		if (sessionOrderList==null) {
			orderList.add(order);
		} else {
			int dupCnt=0;
			// 동일제품코드와 사이즈가 있으면 주문갯수만 더해서 리스트를 업데이트한다.
			for (OrderList isOrder : sessionOrderList) {
				if (isOrder.getPrdt_cd().equals(order.getPrdt_cd())
				 && isOrder.getPrdt_sz().equals(order.getPrdt_sz())) {

					int cnt = isOrder.getOrder_cnt()+order.getOrder_cnt();
					isOrder.setOrder_cnt(cnt);
					dupCnt++;
				}
				orderList.add(isOrder);
			}
			
			System.out.println("1.dupCnt"+dupCnt);
			
			if (dupCnt==0) {
				System.out.println("2.dupCnt"+dupCnt);
				orderList.add(order);
			}
		}
		session.setAttribute("OrderList", orderList);
	}
}
