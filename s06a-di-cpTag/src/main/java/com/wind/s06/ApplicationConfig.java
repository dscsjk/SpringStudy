package com.wind.s06;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public Family family1() {

		Family family = new Family("그레고리팩", "오드리햅번");
		family.setBrotherName("프랑켄슈타인");
		
		
		return family;
	}
	
	@Bean
	public Family family2() {
		Family family = new Family("신성일", "엄앵란");
		family.setBrotherName("당나귀");
			
		return family;
	}
}
