## 欢迎来到Leon的springcloud世界

   leon-springcloud-1.5.8 脱胎在公司核心系统的架构基础上，采用springclou微服务架构，基于springboot-1.5.8。因公司业务和成本限制，某些具体服务采用折中方案，后续会慢慢提取出来，并做好优化以及统一相关API。
   
   后续会逐步升级到springboot2.0,并进行docker容器化。
   并会进行zookeeper等不同方案的集成。
   
   敬请关注~

### 基础环境要求

 - Encoding : UTF-8
 - IDE : IntelliJ IDEA 2017 +
 - JDK : jdk1.8 +
 - Maven : apache-maven-3.2.2 +  建议搭建[nexus](https://www.sonatype.com/download-oss-sonatype)服务器。
 - Springboot : 1.5.8 or 1.5.9 
 - Redis : redis 3.0 +
 - Nginx : nginx-1.10.2 +
 - MySql : mysql 5.7 +
 - RabbitMQ ： RabbitMQ 3.5.6
 

### 相关服务模块
 
   由于maven聚合springboot项目有太多坑，所以每一个子服务都采用独立项目，省心省力省时间，也方便项目中的开发权限管理。
    
   1. leon-lib  公共依赖包，需要打包发布到nexus仓库，或者本地仓库进行调用即可。
   2. leon-srv-eureka  注册中心
   ```
   - leon-srv-eureka-01  注册中心集群负载 节点1
   - leon-srv-eureka-02  注册中心集群负载 节点2
   ```
   3. leon-srv-config  配置中心
   4. leon-srv-auth  鉴权中心
   5. leon-srv-xxl-job 分布式调度中心
   6. leon-srv-sba  监控中心
   7. leon-srv-zipkin 全链路追踪
   8. leon-srv-cache  缓存管理
   9. leon-srv-redis  redis服务
   10. leon-srv-websocket  websocket服务
   11.  leon-srv-zuul 路由服务
   12.  leon-srv-springboot-demo（单数据源）   springboot集成druid、mybatis的小栗子
   13.  leon-srv-springboot-merge-demo (多数据源)  springboot集成druid、mybatis，动态切换数据源的小栗子
   
   .
   .
   .

### 参考资料

   - [史上最简单的 SpringCloud 教程](https://blog.csdn.net/forezp/article/details/70148833/).
   - [Spring Cloud 中文网](https://springcloud.cc/).
   - [Spring 官网](https://spring.io/).
   - [许雪里 开源社区](http://www.xuxueli.com/).
   - [Echarts](http://echarts.baidu.com/).

### 书籍
    
   - Nginx 高性能Web服务详解
   - Spring 实战
   - Spring Boot实战 ,丁雪丰 (译者) 
   - spring cloud 微服务实战
   - thymeleaf_3.0.5_中文参考手册
   - 阿里巴巴Java开发手册
   - 微服务设计(中文完整版)
   - 深入理解JVM虚拟机
    
### 联系方式
 
   - Email : [swchenminglei@163.com](swchenminglei@163.com).
   
### 致谢

   TKS~
   
    
    
     
 
 


