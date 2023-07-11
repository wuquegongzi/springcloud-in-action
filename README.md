## 欢迎来到springcloud世界

micro-springcloud-1.5.8 脱胎于公司核心系统的架构基础上，采用springcloud微服务架构，基于springboot-1.5.8。因公司业务和成本限制，某些具体服务采用折中方案。

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
    
   1. micro-lib  公共依赖包，需要打包发布到nexus仓库，或者本地仓库进行调用即可。
   2. micro-eureka  注册中心   
      样例：单实例：[http://localhost:8081/](http://localhost:8081/)  账户名：wf2018  密码： wf2018!
   ```
   -  micro-eureka-load  注册中心集群版
   ```
   3.  micro-config  配置中心
   ```
   -  micro-config-svn  配置中心 SVN版
   -  micro-config-git  配置中心 git版
   ```
   4.  micro-auth  鉴权中心
   5.  micro-xxl-job 分布式调度中心
   6.  micro-sba  监控中心
   7.  micro-zipkin 全链路追踪
   8.  micro-cache  缓存管理
   9.  micro-redis  redis服务
   10. micro-websocket  websocket服务
   11. micro-zuul 路由服务
   12. micro-demo-springboot（单数据源）   springboot集成druid、mybatis的小栗子
   13. micro-demo-springboot-merge (多数据源)  springboot集成druid、mybatis，动态切换数据源的小栗子
   
   .
   .
   .

### 参考资料

   - [史上最简单的 SpringCloud 教程](https://blog.csdn.net/forezp/article/details/70148833/).
   - [Spring Cloud 中文网](https://springcloud.cc/).
   - [Spring 官网](https://spring.io/).
   - [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/).
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
   
    
    
     
 
 


