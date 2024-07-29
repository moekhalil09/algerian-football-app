package com.springboot.algerian_football_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "com.springboot.algerian_football_app.repository")
public class AlgerianFootballAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgerianFootballAppApplication.class, args);
	}

}
