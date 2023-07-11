package com.iwufang.websocket.config;

import cn.com.gmmedicare.common.utils.CommonUtils;
import cn.com.gmmedicare.common.utils.GsonUtils;
import com.iwufang.websocket.model.User;
import com.iwufang.websocket.rpcservice.CacheRemoteService;
import com.iwufang.websocket.service.UserService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * websocket 配置
 *
 * 通过EnableWebSocketMessageBroker
 * 开启使用STOMP协议来传输基于代理(message broker)的消息,
 * 此时浏览器支持使用@MessageMapping 就像支持@RequestMapping一样。
 */
@Configuration
@EnableWebSocketMessageBroker
@Log4j
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    UserService userService;

    @Autowired
    CacheRemoteService cacheRemoteService;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry
                .addEndpoint("/leon-socket")
                .setAllowedOrigins("*")
                .addInterceptors(new HandshakeInterceptor() {
            /**
             * websocket握手
             */
            @Override
            public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                    WebSocketHandler wsHandler,Map<String, Object> attributes) throws Exception {

                ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
                HttpServletRequest req =  servletServerHttpRequest.getServletRequest();

                String type = req.getParameter("type");
                String clientId = req.getParameter("clientId");
                String userCode = req.getParameter("userCode");
                String token = "";

                if(StringUtils.isBlank(userCode) || StringUtils.isBlank(clientId)){
                    return false;
                }

                User user = new User(type,userCode,clientId,token);
                //保存认证用户
                attributes.put("user", (Principal)user);

                Map map = new HashMap(1);
                map.put("ws","http://"+CommonUtils.getLocalHostLANAddress()+":"+serverPort+"/any-socket");
                cacheRemoteService.set("1",
                        "WEBSOCKET:"+user.getUserCode()+"||"+user.getClientId(),
                        GsonUtils.MapsToGson(map),3*60*60*1000);

                return true;
            }

            @Override
            public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

            }
        }).setHandshakeHandler(new DefaultHandshakeHandler(){
            @Override
            protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                //设置认证用户
                return (Principal)attributes.get("user");
            }
        })
        .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
        messageBrokerRegistry.enableSimpleBroker("/topic", "/queue");
    }

    @Override
    public void configureWebSocketTransport(final WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
            @Override
            public WebSocketHandler decorate(final WebSocketHandler handler) {
                return new WebSocketHandlerDecorator(handler) {
                    @Override
                    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {

                        Principal pr = session.getPrincipal();
                        if(null != pr){
                            String username = session.getPrincipal().getName();
                            log.info("online: " + username);

                            userService.addUser((User)session.getPrincipal());

                        }else{
                            log.info("online:用户信息为空！");
                        }

                        super.afterConnectionEstablished(session);
                    }

                    @Override
                    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
                            throws Exception {
                        Principal pr = session.getPrincipal();
                        if(null != pr){
                            String username = session.getPrincipal().getName();
                            log.info("offline: " + username);
                            userService.deleteUser((User)session.getPrincipal());
                        }else{
                            log.info("offline:用户信息为空！");
                        }
                        super.afterConnectionClosed(session, closeStatus);
                    }
                };
            }
        });
        super.configureWebSocketTransport(registration);
    }
}
