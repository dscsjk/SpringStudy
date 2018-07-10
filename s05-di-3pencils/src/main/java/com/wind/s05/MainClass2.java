package com.wind.s05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wind.s05.ApplicationConfig;


public class MainClass2 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		
		pencil = ctx.getBean("pencil1", Pencil.class);
		pencil.use();
		
		pencil = ctx.getBean("pencil2", Pencil.class);
		pencil.use();
		ctx.close();
		
	}

}
