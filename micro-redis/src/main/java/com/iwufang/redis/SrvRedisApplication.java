package com.iwufang.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SrvRedisApplication {

	private static Logger logger =  LoggerFactory.getLogger(SrvRedisApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SrvRedisApplication.class, args);
		logger.info("【【【【【【 redis 微服务 】】】】】】已启动.");
	}
}
