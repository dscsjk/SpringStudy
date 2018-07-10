package com.wind.s05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public Pencil pencil() {
		Pencil pencil = new Pencil4B();
		return pencil;
	}
	@Bean
	public Pencil pencil1() {
		Pencil pencil = new Pencil6B();
		return pencil;
	}
	@Bean
	public Pencil pencil2() {
		Pencil pencil = new Pencil6BWithEraser();
		return pencil;
	}
}
