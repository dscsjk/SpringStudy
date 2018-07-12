package com.wind.s06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("이믊 : " +student1.getName());

		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("이믊 : " +student2.getName());
		ctx.close();

	}

}
