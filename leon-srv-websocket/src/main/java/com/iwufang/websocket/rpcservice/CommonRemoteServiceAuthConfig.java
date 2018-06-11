package com.iwufang.websocket.rpcservice;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 认证配置
 * @package: cn.com.gmmedicare.datasyn.config
 * @author: 陈明磊<minglei.chen@gm-medicare.com>
 * @date: 2017/11/2 15:00
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Configuration
public class CommonRemoteServiceAuthConfig {

    @Value("${security.user.name}")
    private String securityUserName;
    @Value("${security.user.password}")
    private String securityUserPassword;
    /**
     * 此方法主要配置登录 远程服务器的帐号与密码。
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor(securityUserName, securityUserPassword);
    }
}
