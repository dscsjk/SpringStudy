package com.doxmo.web.servies;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.doxmo.web.dao.ProductDao;
import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.Dxm05;
import com.doxmo.web.dto.Dxm15;

public class PrdtDetailService implements DxmService {

	@Override
	public void excute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		ProductDao dxmDao = new ProductDao();
		Dxm03 dxm03 = dxmDao.getPrdt(request.getParameter("prdt_cd"));
		model.addAttribute("prdt", dxm03);
		
		Dxm05 dxm05 = dxmDao.getPrdtDetail(request.getParameter("prdt_cd"));
		model.addAttribute("prdtDetail", dxm05);
		
		ArrayList<Dxm15> dxm15 = dxmDao.getNutrientList(request.getParameter("prdt_cd"));
		model.addAttribute("prdtNutri", dxm15);
	}
}
