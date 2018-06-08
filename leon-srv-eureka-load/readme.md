- 启动集群节点1 ：nohup java -jar leon-srv-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1  &
- 启动集群节点2 ：nohup java -jar leon-srv-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2  &
- 启动集群节点3 ：nohup java -jar leon-srv-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3  &



**配置方式：**
``` 
eureka.client.service-url.defaultZone=http://leon2018:leon2018!@localhost:1001/eureka/,http://leon2018:leon2018!@localhost:1002/eureka/,http://leon2018:leon2018!@localhost:1003/eureka/

#开启健康检查（需要spring-boot-starter-actuator依赖）
eureka.client.healthcheck.enabled = true
#租期更新时间间隔（默认30秒）
eureka.instance.lease-renewal-interval-in-seconds=5
#租期到期时间（默认90秒）
eureka.instance.lease-expiration-duration-in-seconds=10
```
