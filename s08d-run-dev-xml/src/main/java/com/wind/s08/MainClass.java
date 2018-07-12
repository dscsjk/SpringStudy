package com.wind.s08;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {

	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		if (str.equals("dev")) {
			config="dev";
		} else if (str.equals("run"))
			config ="run";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:applicationCTX_dev.xml","classpath:applicationCTX_run.xml");
		
		ServerInfo info = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip : " +info.getIpNum());
		System.out.println("port : " +info.getPortNum());
		scanner.close();
	}

}
