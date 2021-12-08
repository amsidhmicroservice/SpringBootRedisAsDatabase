package com.amsidh.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRedisAsDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisAsDatabaseApplication.class, args);
	}

}
