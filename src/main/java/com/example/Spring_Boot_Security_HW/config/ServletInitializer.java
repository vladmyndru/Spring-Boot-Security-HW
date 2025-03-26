package com.example.Spring_Boot_Security_HW.config;

import com.example.Spring_Boot_Security_HW.SpringBootSecurityHwApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootSecurityHwApplication.class);
	}

}
