package com.wind.s07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("이믊 : " +student.getName());
		System.out.println("이믊 : " +student.getAge());
		OtherStudent otherStudent = ctx.getBean("otherStudent", OtherStudent.class);
		System.out.println("이믊 : " +otherStudent.getName());
		System.out.println("이믊 : " +otherStudent.getAge());
		ctx.close();

	}

}
