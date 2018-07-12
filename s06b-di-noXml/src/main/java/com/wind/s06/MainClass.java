package com.wind.s06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");

		Student student1 = ctx.getBean("student1", Student.class);
	
		System.out.println(student1.getName());
		System.out.println(student1.getAge());

		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		
		Conan student3 =ctx.getBean("conan", Conan.class);
		student3.setName("코난");
		student3.setAge(15);
		System.out.println(student3.getName());
		System.out.println(student3.getAge());
		
		ctx.close();
		 

	}

}
