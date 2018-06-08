package com.gmmedicare.gmsrvzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableDiscoveryClient //注册到eureka
@EnableZipkinStreamServer //使用Stream方式启动ZipkinServer
public class GmSrvZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmSrvZipkinApplication.class, args);
	}
}
