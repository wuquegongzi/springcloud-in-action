package com.iwufang.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @package: com.iwufang.cache
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2017/11/1 16:18
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class SrvCacheApplication {

	private static Logger logger =  LoggerFactory.getLogger(SrvCacheApplication.class);

	@Value("spring.application.name")
	private String applicationName;
	@Value("${security.user.name}")
	private String securityUserName;
	@Value("${security.user.password}")
	private String securityUserPassword;

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	@LoadBalanced
	RestOperations rest(RestTemplateBuilder restTemplateBuilder) {
//		logger.info(securityUserName+"-------------"+securityUserPassword);
		return restTemplateBuilder.basicAuthorization(securityUserName, securityUserPassword).build();
	}


	public static void main(String[] args)
	{

		SpringApplication.run(SrvCacheApplication.class, args);
		logger.info("【【【【【【 cache管理 微服务 】】】】】】已启动.");
	}
}
