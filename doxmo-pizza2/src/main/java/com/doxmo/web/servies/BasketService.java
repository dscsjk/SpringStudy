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

public class BasketService implements DxmService {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		System.out.println("BasketService");
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		OrderPrdt order = new OrderPrdt();
		
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		System.out.println(order.getPrdt_cd());
		
		order.setPrdt_img(request.getParameter("prdt_img"));
		System.out.println(order.getPrdt_img());

		order.setPrdt_nm(request.getParameter("prdt_nm"));
		System.out.println(order.getPrdt_nm());

		String prdt_sz=request.getParameter("prdt_sz");
		
//		order.setPrdt_sz(request.getParameter("prdt_sz"));
//		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setPrdt_sz(prdt_sz.substring(0, 1));
		System.out.println(order.getPrdt_sz());
		
		order.setPrice(Integer.parseInt(prdt_sz.substring(2)));
		System.out.println(order.getPrice());
		
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		System.out.println(order.getOrder_cnt());
		
		HttpSession session = request.getSession();
		ArrayList<OrderPrdt> orderList = new ArrayList<OrderPrdt>();
		ArrayList<OrderPrdt> sessionOrderList = (ArrayList<OrderPrdt>) session.getAttribute("OrderList");
		
		if (sessionOrderList==null) {
			orderList.add(order);
		} else {
			int dupCnt=0;
			// 동일제품코드와 사이즈가 있으면 주문갯수만 더해서 리스트를 업데이트한다.
			for (OrderPrdt isOrder : sessionOrderList) {
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
