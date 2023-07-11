package com.iwufang.websocket.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @package: com.iwufang.websocket.config
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2018/3/19 12:59
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Configuration
public class UndertowConfig {

    /**
     * 启用HTTP2作为web的协议
     * @return
     */
    @Bean
    UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {

        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();

        // 这里也可以做其他配置
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));

        return factory;
    }

}
