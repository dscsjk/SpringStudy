package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.doxmo.web.dao.OrderDao;
import com.doxmo.web.dto.Dxm07;
import com.doxmo.web.dto.Dxm08;
import com.doxmo.web.dto.OrderPrdt;
import com.doxmo.web.dto.RcptTp;
import com.doxmo.web.dto.User;

public class OrderService implements DxmService {

	@Override
	public void excute(Model model) {
		System.out.println("OrderService()");
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		// 세션 정보 추출
		RcptTp sRcptTp = (RcptTp) session.getAttribute("RcptTp");
		User sUser = (User) session.getAttribute("User");
		ArrayList<OrderPrdt> sOrderList = (ArrayList<OrderPrdt>) session.getAttribute("OrderList");
		
		// 주문서 정보 작성
		Dxm07 order = new Dxm07();
		order.setU_id(sUser.getU_id());
		order.setStore_cd(sRcptTp.getRcpt_cd());
		order.setTt_pay(Integer.parseInt(request.getParameter("tt_pay")));
		order.setPay_tp(request.getParameter("pay_tp"));
		order.setRcpt_tp(sRcptTp.getRcpt_tp()); ;
		order.setRcpt_nm(request.getParameter("rcpt_nm"));
		order.setRcpt_tel(request.getParameter("rcpt_tel"));
		order.setRcpt_addr(sRcptTp.getRcpt_addr());
		order.setMemo(request.getParameter("memo"));

		// 주문 품목 장성
		ArrayList<Dxm08> prdtList = new ArrayList<Dxm08>();
		for( OrderPrdt sOrderPrdt : sOrderList ) {
			Dxm08 orderPrdt = new Dxm08();
			orderPrdt.setPrdt_cd(sOrderPrdt.getPrdt_cd());
			orderPrdt.setPrdt_sz(sOrderPrdt.getPrdt_sz());
			orderPrdt.setOrder_cnt(sOrderPrdt.getOrder_cnt());
			prdtList.add(orderPrdt);
		}
		
		// DB에 insert
		OrderDao orderDao = new OrderDao();
		Boolean rtn = false;
		rtn = orderDao.setOrder(order, prdtList);
		if (rtn==true) {
			session.removeAttribute("Order");
			session.removeAttribute("OrderList");
		}
		model.addAttribute("rtn", rtn);
	}
}
