package member.model;

public class Dxm01 {
	private String u_id;
	private String u_name;
	private String u_tel;
	private String u_zip;
	private String u_addr;
	private String pswd;
	private String updt_dt;
	private String crd_dt;
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	public String getU_zip() {
		return u_zip;
	}
	public void setU_zip(String u_zip) {
		this.u_zip = u_zip;
	}
	public String getU_addr() {
		return u_addr;
	}
	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getUpdt_dt() {
		return updt_dt;
	}
	public void setUpdt_dt(String updt_dt) {
		this.updt_dt = updt_dt;
	}
	public String getCrd_dt() {
		return crd_dt;
	}
	public void setCrd_dt(String crd_dt) {
		this.crd_dt = crd_dt;
	}
	
	@Override
	public String toString() {
		String str = u_id + ','
				+ u_name + ',' 
				+ u_tel + ','
				+ u_zip + ','
				+ u_addr + ','
				+ pswd + ','
				+ updt_dt + ','
				+ crd_dt;
		return str;
	}
}
