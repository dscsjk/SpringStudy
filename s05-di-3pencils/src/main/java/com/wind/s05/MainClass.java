package com.wind.s05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml", "classpath:applicationCTX1.xml", "classpath:applicationCTX2.xml");
		
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		
		pencil = ctx.getBean("pencil1", Pencil.class);
		pencil.use();
		
		pencil = ctx.getBean("pencil2", Pencil.class);
		pencil.use();
		ctx.close();
		
	}

}
