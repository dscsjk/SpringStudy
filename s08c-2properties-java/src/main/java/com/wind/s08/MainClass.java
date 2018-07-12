package com.wind.s08;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection connection =ctx.getBean("adminConfig",AdminConnection.class);
		System.out.println("admin Id "+connection.getAdminId());
		System.out.println("admin pw "+connection.getAdminPw());
		System.out.println("sub_admin Id "+connection.getSubAdminId());
		System.out.println("sub_admin pw "+connection.getSubAdminPw());
		
		ctx.close();
	}

}
