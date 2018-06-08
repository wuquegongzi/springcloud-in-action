# 启动命令：
- 启动节点1 ： nohup java -jar leon-srv-conf-0.0.1-SNAPSHOT.jar >logs/leon-srv-conf-log2001.log 2>&1 &
- 启动节点2 ： nohup java -jar leon-srv-conf-0.0.1-SNAPSHOT.jar  --server.port=2002 >logs/leon-srv-conf-log2002.log 2>&1 &  可更换端口号


**通过注册中心访问配置中心  配置示例**

```
spring.application.name=xxxxxx
#注册中心
eureka.client.serviceUrl.defaultZone=

#配置中心
spring.cloud.config.discovery.enabled=true
spring.cloud.config.discovery.serviceId=LEON-SRV-CONF
spring.cloud.config.username=leon2018
spring.cloud.config.password=leon2018!
##指明远程仓库的分支
spring.cloud.config.label=master
spring.cloud.config.name=${spring.application.name}
spring.cloud.config.profile=dev
```
