package com.doxmo.web;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doxmo.web.dao.DxmDao;
import com.doxmo.web.dto.Dxm01;
import com.doxmo.web.dto.OrderPrdt;
import com.doxmo.web.dto.User;


@Controller
public class DoxmoController {

	@Autowired
	private SqlSession sqlSession;
	
	// 트랜잭션 처리
//	@Autowired
//	private DataSourceTransactionManager transactionManager;
	
	@RequestMapping("/prdt_list")
	public String prdt_list(HttpServletRequest request, Model model) {
		String prdt_tp = null;
		prdt_tp = request.getParameter("prdt_tp");
		if ( prdt_tp == null) prdt_tp = "01";
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("dxm03",dxmDao.getPrdtListDao(prdt_tp));
		model.addAttribute("prdt_tp",prdt_tp);
		return "prdt_list";
	}
	
	@RequestMapping("/prdt_detail")
	public String prdt_detail( HttpServletRequest request, Model model) {
		System.out.println("/prdt_detail");
		String prdt_cd = request.getParameter("prdt_cd");

		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("prdt", dxmDao.getPrdtDao(prdt_cd));
		model.addAttribute("prdtPrice", dxmDao.getPrdtPriceDao(prdt_cd));
		model.addAttribute("prdtDetail", dxmDao.getPrdtDetailDao(prdt_cd));
		model.addAttribute("prdtNutri", dxmDao.getNutrientListDao(prdt_cd));
		return "prdt_detail";
	}
	
	@RequestMapping("/order_list")
	public String order_list( HttpServletRequest request, Model model) {
		System.out.println("/order_list");
		HttpSession session = request.getSession();
		User sUser = (User) session.getAttribute("User");
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("orderList", dxmDao.getOrderListDao(sUser.getU_id()));
		return "order_list";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		System.out.println("/logout");

		HttpSession session = request.getSession(true);
		session.removeAttribute("User");
		session.removeAttribute("RcptTp");
		session.removeAttribute("Order");
		session.removeAttribute("OrderList");
		session.invalidate();
		return "logout";
			
	}

	
	@RequestMapping("/login_view")
	public String login_view( ) {
		System.out.println("/login");
		return "login1";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("/login");
		model.addAttribute("request", request);

		// 로그인 정보 존재시 세션에 User값을 설정한다. 
		if (getUserInfo(request)== false) {
			System.out.println("고객정보가 존재하지 않음");
			return "login2";
		}			

		return "redirect:prdt_list";
	}
	
	public Boolean getUserInfo(HttpServletRequest request) {
		System.out.println("/getUserInfo");
		
		String u_id = request.getParameter("u_id");
		String pswd = request.getParameter("pswd");
		System.out.println("uid:"+u_id+" pswd:"+pswd);

		// 로그인 정보 확인하고 값을 가져온다.
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		Dxm01 dxm01 = dxmDao.getUserInfoDao(u_id, pswd, 1);
		
		if (dxm01 == null) return false;
		
		User user = new User();
		user.setU_id(dxm01.getU_id());
		user.setU_name(dxm01.getU_name());
		user.setU_tel(dxm01.getU_tel());
		
		HttpSession session = request.getSession(true);
		session.setAttribute("User", user);
		return true;
	}
	
	
	@RequestMapping("/login_basket")
	public String login_basket(HttpServletRequest request, Model model) {
		System.out.println("/login_basket");
		
		model.addAttribute("request", request);
		if (getUserInfo(request)== false) {
			System.out.println("고객정보가 존재하지 않음");
			return "login2";
		} else {
				// 로그인전의 주문상품을 넘긴다.
				getStoreList(request, model);
				return "rcpt_tp";
		} 
	}

	public void getStoreList(HttpServletRequest request, Model model) {
		System.out.println("/getStoreList");
		
		OrderPrdt order = new OrderPrdt();
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		String prdt_sz=request.getParameter("prdt_sz");
		order.setPrdt_sz(prdt_sz.substring(0, 1));
		order.setPrice(Integer.parseInt(prdt_sz.substring(2)));
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		model.addAttribute("Order", order);
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("RcptTpList", dxmDao.getStoreListDao());
	}

	@RequestMapping("/basket")
	public String basket(HttpServletRequest request,Model model) {
		System.out.println("/basket");

		HttpSession session = request.getSession(false);
		model.addAttribute("request", request);
		
		// 세션이 존재하지 않으면 login화면으로 가기
		if (session.getAttribute("User") == null) {
			System.out.println(">> User세션 is null");
			
			// 로그인전의 주문상품을 넘긴다.
			OrderPrdt order = new OrderPrdt();
			order.setPrdt_cd(request.getParameter("prdt_cd"));
			order.setPrdt_img(request.getParameter("prdt_img"));
			order.setPrdt_nm(request.getParameter("prdt_nm"));
			String prdt_sz=request.getParameter("prdt_sz");
			order.setPrdt_sz(prdt_sz.substring(0, 1));
			order.setPrice(Integer.parseInt(prdt_sz.substring(2)));
			System.out.println("order_cnt->"+request.getParameter("order_cnt"));
			order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
			System.out.println(order.getOrder_cnt());
			
			model.addAttribute("Order", order);
			return "login3";
		} 
		// 주문방법이 존재하지 않으면 세션에 임시로 주문상품 저장하고 주문방법 선택화면으로 가기
		if ( session.getAttribute("RcptTp") == null ) { 
			System.out.println(">> 주문방법 is null");

			getStoreList(request, model);
			return "rcpt_tp";
		}
		// 로그인과 주문방법이 존재하면 주문정보를 세션에 담고 제품리스트화면으로 가기
		System.out.println(">> 세션과 주문방법이 존재 ");
		BasketService(request);

		return "redirect:prdt_list";
	}
	
	public void BasketService(HttpServletRequest request) {
		// request parameter 값을 가져온다.
		System.out.println("BasketService");
		OrderPrdt order = new OrderPrdt();
		
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		String prdt_sz=request.getParameter("prdt_sz");
		
		order.setPrdt_sz(prdt_sz.substring(0, 1));
		order.setPrice(Integer.parseInt(prdt_sz.substring(2)));
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
