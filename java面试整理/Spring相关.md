## Springboot相关

### 1. 什么是Springboot？

Springboot是Spring组件一站式解决方案，简化了Spring的难度，简化配置，提供了各种启动器，开发者能够快速上手。

优点：

- 独立运行

  内嵌各种Servlet容器，Tomcat、Jetty等，Springboot直接打成一个可执行的Jar包就能独立运行，所有的依赖都在Jar包里。

- 简化配置

  spring-boot-starter-web启动器自动依赖其他组件，简少了maven的配置。

- 自动配置

  Spring Boot能根据当前类路径下的类、jar包来自动配置bean，如添加一个spring-boot-starter-web启动器就能拥有web的功能，无需其他配置。

- 无代码生成和XML配置

  Spring Boot配置过程中无代码生成，也无需XML配置文件就能完成所有配置工作，这一切都是借助于条件注解完成的，这也是Spring4.x的核心功能之一。

- 应用监控

  Spring Boot提供一系列端点可以监控服务及应用，做健康检测。

### 2. Springboot核心配置文件有几个？区别？

Spring Boot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 Spring Boot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

- 使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；
- 一些固定的不能被覆盖的属性；
- 一些加密/解密的场景；

### 3. Spring Boot 的配置文件有哪几种格式？它们有什么区别？

.properties 和 .yml，它们的区别主要是书写格式不同。

1).properties

app.user.name = javastack

2).yml

app: user: name: javastack

另外，.yml 格式不支持 `@PropertySource` 注解导入配置。

### 4. Spring Boot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 Spring Boot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 @Configuration 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。

### 5. 如何开启Springboot？

1）继承spring-boot-starter-parent项目

2）导入spring-boot-dependencies项目依赖

### 6. Springboot需要独立的运行容器吗？

可以不需要，内置了 Tomcat/ Jetty 等容器。

### 7.运行Springboot有哪几种方式？

1）打包用命令或者放到容器中运行

2）用 Maven/ Gradle 插件运行

3）直接执行 main 方法运行

等等

### 8. Spring IOC 



https://mp.weixin.qq.com/s?__biz=MzI4Njg5MDA5NA==&mid=2247483946&idx=1&sn=bb21dfd83cf51214b2789c9ae214410f&chksm=ebd7432bdca0ca3ded6ad9b50128d29267f1204bf5722e5a0501a1d38af995c1ee8e37ae27e7&scene=21#wechat_redirect

IOC--控制翻转

**针对问题**：解决对象耦合的问题，有利于功能的复用，能够使程序的结构变得非常灵活。

在spring中，对象的属性是由对象自己创建的，就是正向流程；正向流程导致了对象于对象之间的高耦合。

```
A a = new A(); 
```

如果属性不是对象创建，而是由spring来自动进行装配，就是控制反转。



**context上下文和bean**

spring进行IOC实现时使用的有两个概念：context上下文和bean。

所有被spring管理的、由spring创建的、用于依赖注入的对象，就叫做一个bean。Spring创建并完成依赖注入后，所有bean统一放在一个叫做context的上下文中进行管理。



### 9. Spring AOP

1. 基本概念

   ```markdown
   - 通知 Advice
   
     Before、After、After-returning、After-throwing、Around
   
   - 切点 Pointcut
   
     对应系统中的方法，是定义在切面中的方法，和通知一起使用，一起组成切面。
   
   - 连接点 Join point
   
     理论上，程序执行过程中的任何时点都可以作为织入点，而所有这些执行时点都是Join point。
   
     但Spring AOP目前仅支持方法执行，连接点就是执行切点和切入通知的地方。
   
   - 切面 Aspect
   
     切面是切点和通知的集合（一般单独作为一个类），它定义了切面的全部内容，何时在何处完成什么功能。
   
   - 引入 Introduction
   
   - 织入 Weaving
   
     Spring和其他纯Java AOP框架一样，在运行时完成织入。
   ```

   

2. Spring对AOP的支持

   ```
   Spring AOP同时支持CGLIB、ASPECTJ、JDK动态代理。
   当真是对象有实现接口时，默认使用JDK动态代理，否则采用CGLIB代理。
   ```

   