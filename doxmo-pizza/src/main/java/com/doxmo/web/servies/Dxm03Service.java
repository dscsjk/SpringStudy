package com.doxmo.web.servies;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.doxmo.web.dao.Dxm03Dao;
import com.doxmo.web.dto.Dxm03;

public class Dxm03Service implements DxmService {

	@Override
	public void excute(Model model) {
		Dxm03Dao dxm03Dao = new Dxm03Dao();
		ArrayList<Dxm03> dxm03 = dxm03Dao.getPrdtList("01");
		model.addAttribute("dxm03", dxm03);
	}
}
