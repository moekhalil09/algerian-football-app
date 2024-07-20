package com.springboot.algerian_football_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AlgerianFootballAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgerianFootballAppApplication.class, args);
	}

}
