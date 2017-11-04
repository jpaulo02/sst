package com.brogrammers.sst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = { "com.brogrammers.sst" })
@EnableScheduling
public class SstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SstApplication.class, args);
	}
}
