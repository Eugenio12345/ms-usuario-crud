package com.database.system.wsconsumedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration 
@EntityScan(basePackages = {"com.database.system.wsconsumedatabase.dto"})
@ComponentScan(value = "com.database.system.wsconsumedatabase")
public class AppStarter {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}

}
