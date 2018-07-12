package com.wind.s08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@Profile("dev")
public class ApplicationConfigDev {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		
		info.setIpNum("localhost");
		info.setPortNum("8181");
		return info;
	}
	
}
