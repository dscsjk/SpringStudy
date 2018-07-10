package com.wind.s06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Family family = ctx.getBean("family1", Family.class);
	
		System.out.println(family.getFatherName());
		System.out.println(family.getMotherName());
		System.out.println(family.getBrotherName());
		
		Family family2 = ctx.getBean("family2", Family.class);
		
		System.out.println(family2.getFatherName());
		System.out.println(family2.getMotherName());
		System.out.println(family2.getBrotherName());
		ctx.close();
		
	}

}
