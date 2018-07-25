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

public class RcptTpService implements DxmService  {

	@Override
	public void excute(Model model) {
		System.out.println("RcptTpService()");
		// request parameter 값을 가져온다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		OrderList order = new OrderList();
		RcptTp rcptTp = new RcptTp();
		
		rcptTp.setRcpt_tp(request.getParameter("rcpt_tp"));
		rcptTp.setRcpt_addr(request.getParameter("rcpt_addr"));
		rcptTp.setRcpt_cd(request.getParameter("rcpt_cd"));
		rcptTp.setRcpt_nm(request.getParameter("rcpt_nm"));
		rcptTp.setRcpt_tel(request.getParameter("rcpt_tel"));
		
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		order.setPrdt_sz(request.getParameter("prdt_sz"));
		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		
		HttpSession session = request.getSession();
		session.setAttribute("RcptTp", rcptTp);
		
		ArrayList<OrderList> orderList = (ArrayList<OrderList>) session.getAttribute("OrderList");
		
		if (orderList==null) {
			orderList = new ArrayList<OrderList>(); 
			orderList.add(order);
		} else {
			int i=0;
			// 동일제품코드와 사이즈가 있으면 주문갯수만 더해서 리스트를 업데이트한다.
			for (OrderList isOrder : orderList) {
				if (isOrder.getPrdt_cd().equals(order.getPrdt_cd())
				 && isOrder.getPrdt_sz().equals(order.getPrdt_sz())) {
					int cnt = isOrder.getOrder_cnt()+order.getOrder_cnt();
					isOrder.setOrder_cnt(cnt);
					orderList.remove(i);
					orderList.add(i,isOrder);
				}
				i++;
			}
		}
		session.setAttribute("OrderList", orderList);
	}
}
