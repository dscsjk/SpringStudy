package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.doxmo.web.dto.OrderPrdt;

public class BasketDelService implements DxmService {

	@Override
	public void excute(Model model) {
		// request parameter 값을 가져온다.
		System.out.println("BasketDelService");
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
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
	}
}
