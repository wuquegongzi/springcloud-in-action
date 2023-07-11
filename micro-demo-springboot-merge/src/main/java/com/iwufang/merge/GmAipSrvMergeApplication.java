package com.iwufang.merge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
//配置druid必须加的注解
@ServletComponentScan
@EnableTransactionManagement
@EnableFeignClients
public class GmAipSrvMergeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmAipSrvMergeApplication.class, args);
    }
}
