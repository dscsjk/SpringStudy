package com.doxmo.web;


import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doxmo.web.dao.DxmDao;
import com.doxmo.web.dto.Dxm01;
import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.Dxm04;
import com.doxmo.web.dto.Dxm07;
import com.doxmo.web.dto.Dxm08;
import com.doxmo.web.dto.OrderPrdt;
import com.doxmo.web.dto.RcptTp;
import com.doxmo.web.dto.User;


@Controller
public class Dxm1Controller {
	final String PRDT_TP_SPEC = "01";
	final String PRDT_TP_CLASSIC = "02";
	final String PRDT_TP_SIDE = "03";
	final String PRDT_TP_DRINK = "04";

	
	// session으로 DB Connect
	@Autowired
	private SqlSession sqlSession;
	// 트랜잭션 처리
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
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
			order.setPrdt_sz(prdt_sz.split(":")[0]);
			order.setPrice(Integer.parseInt(prdt_sz.split(":")[1]));
			order.setPrice_t(Integer.parseInt(prdt_sz.split(":")[1]));

			order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
			
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
		
		order.setPrdt_sz(prdt_sz.split(":")[0]);
		order.setPrice(Integer.parseInt(prdt_sz.split(":")[1]));
		order.setPrice_t(Integer.parseInt(prdt_sz.split(":")[1]));
		
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		System.out.println(order.getOrder_cnt());
		
		HttpSession session = request.getSession();
		ArrayList<OrderPrdt> orderList = new ArrayList<OrderPrdt>();
		
		@SuppressWarnings("unchecked")
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
					isOrder.setPrice_t( isOrder.getPrice()*cnt );
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

	public int getPrdtMaxCnt(HttpServletRequest request, String prdt_cd, String prdt_sz ) {
		System.out.println("getPrdtMaxCnt");

		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<OrderPrdt> sessionOrderList = (ArrayList<OrderPrdt>) session.getAttribute("OrderList");
		
		if (sessionOrderList==null) {
			return 0;
		} else {
			for (OrderPrdt isOrder : sessionOrderList) {
				System.out.println("["+isOrder.getPrdt_cd()+"]"+"["+isOrder.getPrdt_sz()+"]");
				
				if (isOrder.getPrdt_cd().equals(prdt_cd) && isOrder.getPrdt_sz().equals(prdt_sz)) {
					return isOrder.getOrder_cnt();
				}
			}
		}
		return 0;
	}

	@RequestMapping("/basket_del")
	@SuppressWarnings("unchecked")
	public String basket_del( HttpServletRequest request, Model model) {
		System.out.println("/basket_del");
		
		HttpSession session = request.getSession();
		ArrayList<OrderPrdt> orderList = new ArrayList<OrderPrdt>();
		
		// 동일제품코드와 사이즈가 있으면 주문갯수만 더해서 리스트를 업데이트한다.
		for (OrderPrdt isOrder : (ArrayList<OrderPrdt>) session.getAttribute("OrderList")) {
			if (isOrder.getPrdt_cd().equals(request.getParameter("prdt_cd"))
			 && isOrder.getPrdt_sz().equals(request.getParameter("prdt_sz"))) {
				System.out.println("삭제건 존재");
			} else 
				orderList.add(isOrder);
		}
			
		session.setAttribute("OrderList", orderList);

		return "redirect:basket_view";
	}	

	@RequestMapping("/basket_add")
	@SuppressWarnings("unchecked")
	public String basket_add( HttpServletRequest request, Model model) {
		System.out.println("/basket_add");
		
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
					isOrder.setPrice_t( isOrder.getPrice()*order.getOrder_cnt() );
					dupCnt++;
			}
			orderList.add(isOrder);
		}
			
		System.out.println("1.dupCnt"+dupCnt);
			
		session.setAttribute("OrderList", orderList);

		return "redirect:basket_view";
	}	

	@RequestMapping("/basket_view")
	public String basket_view( HttpServletRequest request, Model model) {
		System.out.println("/basket_view");

		HttpSession session = request.getSession();
		RcptTp rcptTp = (RcptTp) session.getAttribute("RcptTp");
		if (rcptTp != null) 
			model.addAttribute("RcptTp", rcptTp);

		User user = (User) session.getAttribute("User");
		if (user != null)
			model.addAttribute("User", user);

		@SuppressWarnings("unchecked")
		ArrayList<OrderPrdt> orderList = (ArrayList<OrderPrdt>) session.getAttribute("OrderList");
		if (orderList != null)
			model.addAttribute("OrderList", orderList);
		return "basket";
	}

	@RequestMapping("/prdt_list")
	public String prdt_list(HttpServletRequest request, Model model) {
		System.out.println("/prdt_list");
		
		String prdt_tp = null;
		
		prdt_tp = request.getParameter("prdt_tp");
		if ( prdt_tp == null) prdt_tp = PRDT_TP_SPEC;
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		ArrayList<Dxm03> dxm03= dxmDao.getPrdtListDao(prdt_tp);
		model.addAttribute("dxm03",dxm03);
		
		if ( prdt_tp.equals(PRDT_TP_SIDE) || prdt_tp.equals(PRDT_TP_DRINK)) {
			HashMap<String, Integer> sideCnt = new HashMap<String, Integer>();
			for (int i=0;i<dxm03.size();i++) {
				int prdt_cnt = getPrdtMaxCnt(request, dxm03.get(i).getPrdt_cd(), "" );
				sideCnt.put(dxm03.get(i).getPrdt_cd(),prdt_cnt);
				model.addAttribute("sideCnt", sideCnt);
			}
		}
		model.addAttribute("prdt_tp",prdt_tp);
		return "prdt_list";
	}
	
	@RequestMapping("/prdt_detail")
	public String prdt_detail( HttpServletRequest request, Model model) {
		System.out.println("/prdt_detail");
		String prdt_cd = request.getParameter("prdt_cd");

		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("prdt", dxmDao.getPrdtDao(prdt_cd));
		
		
		ArrayList <Dxm04> prdtPrice = dxmDao.getPrdtPriceDao(prdt_cd);
		HttpSession session = request.getSession();

		for (int i=0;i<prdtPrice.size();i++) {
			if ( session.getAttribute("OrderList") != null ) {
				if (prdtPrice.get(i).getPrdt_sz()==null) prdtPrice.get(i).setPrdt_sz("");
				prdtPrice.get(i).setPrdt_cnt(getPrdtMaxCnt(request, prdt_cd, prdtPrice.get(i).getPrdt_sz() ));
			}
		}

		model.addAttribute("prdtPrice", prdtPrice);
		model.addAttribute("prdtDetail", dxmDao.getPrdtDetailDao(prdt_cd));
		model.addAttribute("prdtNutri", dxmDao.getNutrientListDao(prdt_cd));
		model.addAttribute("prdt_tp", request.getParameter("prdt_tp"));
		return "prdt_detail";
	}
	
	@RequestMapping("/order_view")
	public String order_view( HttpServletRequest request, Model model) {
		System.out.println("/order_view");

		HttpSession session = request.getSession();
		RcptTp rcptTp = (RcptTp) session.getAttribute("RcptTp");
		if (rcptTp != null) 
			model.addAttribute("RcptTp", rcptTp);

		User user = (User) session.getAttribute("User");
		if (user != null)
			model.addAttribute("User", user);

		@SuppressWarnings("unchecked")
		ArrayList<OrderPrdt> orderList = (ArrayList<OrderPrdt>) session.getAttribute("OrderList");
		if (orderList != null)
			model.addAttribute("OrderList", orderList);
		
		return "order";
	}

	@RequestMapping("/order")
	public String order( HttpServletRequest request, Model model) throws Exception {
		System.out.println("/order");
		model.addAttribute("request", request);

		HttpSession session = request.getSession();
		
		// 세션 정보 추출
		RcptTp sRcptTp = (RcptTp) session.getAttribute("RcptTp");
		User sUser = (User) session.getAttribute("User");
		@SuppressWarnings("unchecked")
		ArrayList<OrderPrdt> sOrderList = (ArrayList<OrderPrdt>) session.getAttribute("OrderList");
		
		// 주문서 정보 작성
		Dxm07 order = new Dxm07();
		long order_no = System.currentTimeMillis();
		order.setOrder_no(String.valueOf(order_no));
		order.setU_id(sUser.getU_id());
		order.setStore_cd(sRcptTp.getRcpt_cd());
		order.setTt_pay(Integer.parseInt(request.getParameter("tt_pay")));
		order.setPay_tp(request.getParameter("pay_tp"));
		order.setRcpt_tp(sRcptTp.getRcpt_tp()); ;
		order.setRcpt_nm(request.getParameter("rcpt_nm"));
		order.setRcpt_tel(request.getParameter("rcpt_tel"));
		order.setRcpt_addr(sRcptTp.getRcpt_addr());
		order.setMemo(request.getParameter("memo"));

//		System.out.println(order.getOrder_no());
//		System.out.println(order.getU_id());
//		System.out.println(order.getStore_cd());
//		System.out.println(order.getTt_pay());
//		System.out.println(order.getPay_tp());
//		System.out.println(order.getRcpt_tp());
//		System.out.println(order.getRcpt_nm());
//		System.out.println(order.getRcpt_tel());
//		System.out.println(order.getRcpt_addr());
//		System.out.println(order.getMemo());

		// 주문 품목 장성
		ArrayList<Dxm08> prdtList = new ArrayList<Dxm08>();
		for( OrderPrdt sOrderPrdt : sOrderList ) {
			Dxm08 orderPrdt = new Dxm08();
			orderPrdt.setOrder_no(String.valueOf(order_no));
			orderPrdt.setPrdt_cd(sOrderPrdt.getPrdt_cd());
			orderPrdt.setPrdt_sz(sOrderPrdt.getPrdt_sz());
			if (orderPrdt.getPrdt_sz().compareTo("")==0) 
				orderPrdt.setPrdt_sz(" ");
			orderPrdt.setOrder_cnt(sOrderPrdt.getOrder_cnt());
			System.out.println(orderPrdt.getOrder_no());
			System.out.println(orderPrdt.getPrdt_cd());
			System.out.println("["+orderPrdt.getPrdt_sz()+"]");
			System.out.println(orderPrdt.getOrder_cnt());

			prdtList.add(orderPrdt);

		}
		
		// DB에 insert
		Boolean rtn = false;
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			dxmDao.setOrderDao(order);
			dxmDao.setOrderListDao(prdtList);
			transactionManager.commit(status);

		} catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
		}

		session.removeAttribute("Order");
		session.removeAttribute("OrderList");
		rtn = true;
		model.addAttribute("rtn", rtn);
		return "order_end";
	}

	@RequestMapping("/order_list")
	public String order_list( HttpServletRequest request, Model model) {
		System.out.println("/order_list");
		
		final int LIST_VIEW = 5; // 출력할 리스트 건수
		final int PAGE_VIEW = 3; // 출력할 페이지 건수
		
		// 조회하고자 하는 페이지값을 가져온다.
		int pageNo = 1;
		if( request.getParameter("pageNo") != null )
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		// 해당 User의 총주문건수를 조회한다.
		HttpSession session = request.getSession();
		User sUser = (User) session.getAttribute("User");
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		int totCount = dxmDao.getTotalOrderCountDao(sUser.getU_id());
		
		// startPage와 endPage값을 구한다.
		int Qtnt = totCount/LIST_VIEW;  // 총건수 를 리스트건수로 나눈 몫 
		int Rmn = totCount%LIST_VIEW; // 총건수 를 리스트건수로 나눈 나머지

		// 1.총페이지 값을 구한다.
		int totPageCnt = 1;
		if ( totCount > LIST_VIEW ) { 
			if ( Rmn == 0 ) totPageCnt = Qtnt;
			else totPageCnt = Qtnt+1 ;
		} 

		// 2.startPageV 구하기
		int startPageV = 1;
		if ( pageNo > PAGE_VIEW ) {
			if ( pageNo%PAGE_VIEW == 0 )
				startPageV = pageNo - PAGE_VIEW + 1;
			else 
				startPageV = ((pageNo/PAGE_VIEW)*PAGE_VIEW) + 1;
		}
		
		// 3.endPageV 구하기
		int endPageV = startPageV+PAGE_VIEW - 1;
		if (totPageCnt < endPageV) 
				endPageV = totPageCnt;
		
		
		// 조회하고자 하는 페이지의 리스트 시작과 끝번호 구하기
		int startList = (pageNo*LIST_VIEW)-LIST_VIEW+1;
		int endList = pageNo*LIST_VIEW;
		
		System.out.println("pageNo->"+pageNo+ "totCnt->"+totPageCnt );
		System.out.println("startPage->"+startList +" endPage->"+ endList);
		System.out.println("startPageV->"+startPageV +" endPageV->"+ endPageV);
		
		model.addAttribute("orderList", dxmDao.getOrderListDao(sUser.getU_id(), startList, endList)); // 리스트정보
		model.addAttribute("nowPage", pageNo ); // 현재 페이지
		model.addAttribute("startPage", startPageV ); // 시작페이지
		model.addAttribute("endPage", endPageV ); // 종료페이지
		model.addAttribute("totCnt", totPageCnt); // 총페이지건수
		model.addAttribute("viewCnt", PAGE_VIEW ); // 출력할 페이지 수
		return "order_list";
	}

	@RequestMapping("/order_detail")
	public String order_detail( HttpServletRequest request, Model model) {
		System.out.println("/order_detail");
		
		String order_no = request.getParameter("order_no");
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("orderDetail", dxmDao.getOrderDetailDao(order_no));
		model.addAttribute("OrderPrdtList", dxmDao.getOrderPrdtListDao(order_no));
		
		return "order_detail";
	}
	
	@RequestMapping("/rcpt_tp_choice")
	public String rcpt_tp_choice( HttpServletRequest request, Model model) {
		System.out.println("/rcpt_tp_choice");
		
		OrderPrdt order = new OrderPrdt();
		RcptTp rcptTp = new RcptTp();
		//배달정보 등록
		rcptTp.setRcpt_tp(request.getParameter("rcpt_tp"));
		rcptTp.setRcpt_addr(request.getParameter("rcpt_addr"));
		rcptTp.setRcpt_cd(request.getParameter("rcpt_cd"));
		rcptTp.setRcpt_nm(request.getParameter("rcpt_nm"));
		rcptTp.setRcpt_tel(request.getParameter("rcpt_tel"));
		//주문제품정보 등록 
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		order.setPrdt_sz(request.getParameter("prdt_sz"));
		order.setPrice(Integer.parseInt(request.getParameter("price")));
		order.setPrice_t(Integer.parseInt(request.getParameter("price")));
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		
		HttpSession session = request.getSession();
		session.setAttribute("RcptTp", rcptTp);
		
		@SuppressWarnings("unchecked")
		ArrayList<OrderPrdt> orderList = (ArrayList<OrderPrdt>) session.getAttribute("OrderList");
		
		if (orderList==null) {
			orderList = new ArrayList<OrderPrdt>(); 
			orderList.add(order);
		} else {
			int i=0;
			// 동일제품코드와 사이즈가 있으면 주문갯수만 더해서 리스트를 업데이트한다.
			for (OrderPrdt isOrder : orderList) {
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
		
		return "redirect:prdt_list";
	}

	public void getStoreList(HttpServletRequest request, Model model) {
		System.out.println("/getStoreList");
		
		OrderPrdt order = new OrderPrdt();
		order.setPrdt_cd(request.getParameter("prdt_cd"));
		order.setPrdt_img(request.getParameter("prdt_img"));
		order.setPrdt_nm(request.getParameter("prdt_nm"));
		
		String prdt_sz=request.getParameter("prdt_sz");
		order.setPrdt_sz(prdt_sz.split(":")[0]);
		order.setPrice(Integer.parseInt(prdt_sz.split(":")[1]));
		order.setPrice_t(Integer.parseInt(prdt_sz.split(":")[1]));
		
		order.setOrder_cnt(Integer.parseInt(request.getParameter("order_cnt")));
		model.addAttribute("Order", order);
		
		DxmDao dxmDao = sqlSession.getMapper(DxmDao.class);
		model.addAttribute("RcptTpList", dxmDao.getStoreListDao());
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

}
