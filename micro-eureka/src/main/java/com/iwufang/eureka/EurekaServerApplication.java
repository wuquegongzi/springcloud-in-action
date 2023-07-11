package com.iwufang.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(EurekaServerApplication.class, args);

		System.out.println("【【【【【【 LEON-SRV-EUREKA 服务注册中心 微服务 单实例 】】】】】】已启动.");
	}

}
