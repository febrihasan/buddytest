package org.ait.project.buddytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BuddytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuddytestApplication.class, args);
	}

}
