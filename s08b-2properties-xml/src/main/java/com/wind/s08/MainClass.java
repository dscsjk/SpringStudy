package com.wind.s08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection connection =ctx.getBean("adminConnection",AdminConnection.class);
		System.out.println("admin Id "+connection.getAdminId());
		System.out.println("admin pw "+connection.getAdminPw());
		System.out.println("sub_admin Id "+connection.getSubAdminId());
		System.out.println("sub_admin pw "+connection.getSubAdminPw());
		
		ctx.close();
	}

}
