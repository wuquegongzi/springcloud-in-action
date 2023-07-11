package com.iwufang.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author leon
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RefreshScope
public class SrvConfApplication {

	public static void main(String[] args) {

		SpringApplication.run(SrvConfApplication.class, args);

		System.out.println("【【【【【【 LEON-SRV-CONF 配置中心 微服务 SVN版】】】】】】已启动.");
	}
}
