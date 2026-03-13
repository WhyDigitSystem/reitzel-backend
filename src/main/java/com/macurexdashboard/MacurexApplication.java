package com.macurexdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MacurexApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacurexApplication.class, args);
	}

}
