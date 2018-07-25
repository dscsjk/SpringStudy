package com.doxmo.web.dto;

public class OrderList {
	private String prdt_cd; 
	private String prdt_img; 
	private String prdt_nm; 
	private String prdt_sz; 
	private int price; 
	private int order_cnt;
	
	public String getPrdt_cd() {
		return prdt_cd;
	}
	public void setPrdt_cd(String prdt_cd) {
		this.prdt_cd = prdt_cd;
	}
	public String getPrdt_img() {
		return prdt_img;
	}
	public void setPrdt_img(String prdt_img) {
		this.prdt_img = prdt_img;
	}
	public String getPrdt_nm() {
		return prdt_nm;
	}
	public void setPrdt_nm(String prdt_nm) {
		this.prdt_nm = prdt_nm;
	}
	public String getPrdt_sz() {
		return prdt_sz;
	}
	public void setPrdt_sz(String prdt_sz) {
		this.prdt_sz = prdt_sz;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	} 
}
