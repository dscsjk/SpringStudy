package com.wind.s06;

import org.springframework.stereotype.Component;

@Component
public class Conan {
	private String name;
	private int age;
	
	

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}
}