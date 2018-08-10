package com.doxmo.web.dto;

public class OrderList {
	
	private String crt_dt ;
	private String rcpt_tp ;
	private String order_no ;
	private String order_prdt ;
	private String tt_pay ;
	private String store_nm	;
	private String store_tel	;
	private String order_st	;
	
	public String getOrder_prdt() {
		return order_prdt;
	}
	public void setOrder_prdt(String order_prdt) {
		this.order_prdt = order_prdt;
	}
	public String getStore_nm() {
		return store_nm;
	}
	public void setStore_nm(String store_nm) {
		this.store_nm = store_nm;
	}
	public String getStore_tel() {
		return store_tel;
	}
	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getTt_pay() {
		return tt_pay;
	}
	public void setTt_pay(String tt_pay) {
		this.tt_pay = tt_pay;
	}
	public String getRcpt_tp() {
		return rcpt_tp;
	}
	public void setRcpt_tp(String rcpt_tp) {
		this.rcpt_tp = rcpt_tp;
	}
	public String getOrder_st() {
		return order_st;
	}
	public void setOrder_st(String order_st) {
		this.order_st = order_st;
	}
	public String getCrt_dt() {
		return crt_dt;
	}
	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}

}
