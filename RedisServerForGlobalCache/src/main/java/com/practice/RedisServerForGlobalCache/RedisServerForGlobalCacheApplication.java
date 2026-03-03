package com.practice.RedisServerForGlobalCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisServerForGlobalCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisServerForGlobalCacheApplication.class, args);
	}

}
