package com.doxmo.web.dao;

import java.util.ArrayList;

import com.doxmo.web.dto.Dxm01;
import com.doxmo.web.dto.Dxm03;
import com.doxmo.web.dto.Dxm04;
import com.doxmo.web.dto.Dxm05;
import com.doxmo.web.dto.Dxm06;
import com.doxmo.web.dto.Dxm07;
import com.doxmo.web.dto.Dxm08;
import com.doxmo.web.dto.Dxm15;
import com.doxmo.web.dto.OrderList;



public interface DxmDao {
	
	public ArrayList<Dxm03> getPrdtListDao(String prdt_tp);
	public Dxm03 getPrdtDao(String prdt_cd);
	public ArrayList<Dxm04> getPrdtPriceDao(String prdt_cd);
	public Dxm05 getPrdtDetailDao(String prdt_cd);
	public ArrayList<Dxm15> getNutrientListDao(String prdt_cd);
	public ArrayList<OrderList> getOrderListDao(String u_id);
	public Dxm01 getUserInfoDao(String u_id, String pswd, int tp);
	public ArrayList<Dxm06> getStoreListDao();
	public Boolean setOrderDao(Dxm07 order);
	public Boolean setOrderListDao(ArrayList<Dxm08> prdtList);
}
