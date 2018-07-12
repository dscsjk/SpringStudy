package com.wind.s08;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements InitializingBean, DisposableBean  {

	private String adminId;
	private String adminPw;
	private String subAdminId;
	private String subAdminPw;
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");

	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getSubAdminId() {
		return subAdminId;
	}

	public void setSubAdminId(String subAdminId) {
		this.subAdminId = subAdminId;
	}

	public String getSubAdminPw() {
		return subAdminPw;
	}

	public void setSubAdminPw(String subAdminPw) {
		this.subAdminPw = subAdminPw;
	}

}
