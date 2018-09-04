package prj0626;

public class OrdNum {
	
	// 1.주문건에 관련된 구조체
	private String orderN;
	private String uId;
	private int tPrice;
	
	public String getOrderN() {
		return orderN;
	}
	public void setOrderN(String orderN) {
		this.orderN = orderN;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public int gettPrice() {
		return tPrice;
	}
	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}
}
