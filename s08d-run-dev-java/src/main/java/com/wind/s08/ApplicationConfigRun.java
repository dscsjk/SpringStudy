package com.wind.s08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigRun {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		
		info.setIpNum("211.25.45.126");
		info.setPortNum("45");
		return info;
	}
	
}
