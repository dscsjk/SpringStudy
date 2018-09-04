package prj0626;

public class Book {
	String bname;
	String uname;
	int price;
	String publisher;
	
	Book (String bname, String uname, int price, String publisher) {
		this.bname = bname;
		this.uname = uname;
		this.price = price;
		this.publisher = publisher;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
