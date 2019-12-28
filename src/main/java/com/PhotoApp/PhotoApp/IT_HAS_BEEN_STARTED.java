package com.PhotoApp.PhotoApp;

import com.PhotoApp.PhotoApp.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class IT_HAS_BEEN_STARTED {

	public static void main(String[] args) {
		SpringApplication.run(IT_HAS_BEEN_STARTED.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder () {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationsContext springApplicationsContext() {
		return new SpringApplicationsContext();
	}

	@Bean(name = "AppProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}

}
