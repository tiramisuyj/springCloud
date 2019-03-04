# springCloud

# hello
1.添加hellocontroller和HelloTest，test中可以模拟接口调用

# springboot配置
1.
server:
	port:8881
-------

2.自定义参数
application.properties:
book.name=springcloudinaction
book.author=yj

@Component
public class Book{
	@Value("${book.name}")
	private String name;
	@Value("${book.author}
	private String author;
	
	//省略get和set
}

3.参数引用
application.properties:
book.name=springcloudinaction
book.author=yj
book.desc=${book.author} is writing 《${book.name}》

4.使用随机数${random}
#随机字符串
blog.value=${random.value}
#随机int
blog.num=${random.int}
#随机long
blog.long=${random.long}
#10以内的随机数
blog.test1=${random.int(10)}
#10-20的随机数
blog.test2=${random.int[10,20]}

5.命令行参数
java -jar ***.jar --server.port=8888

6.多环境配置application-{profile}.properties
开发环境：application-dev.properties
测试环境：application-test.properties
生产环境：application-prod.properties
使用哪个环境在application.properties中配置：spring.profiles.active=dev
或者启动命令设置：java -jar xxx.jar --spring.profiles.active=prod

# actuator
1.引入依赖
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
2.启动项日志增加了端点：
Mapped "{[/health || /health.json]
Mapped "{[/info || /info.json]
.....
(若访问端点出现type=Unauthorized, status=401，则去掉权限校验management.security.enabled=false)
3.原生端点，分为以下三大类
a.应用配置类：获取应用程序中加载的应用配置/环境变量/自动化配置报告等与springboot应用密切相关的配置类信息
b.度量指标类：获取应用程序运行过程中用于监控的度量指标，比如内存信息/线程池信息/http请求书统计等
c.操作控制类：提供了对应用的关闭等操作类功能
应用配置类：
/autoconfig：该端点用来获取应用的自动化配置报告，其中包括所有自动化配置的候选项
/beans：该端点用来获取应用上下文中创建的所有bean
/configprops：该端点用来获取应用中配置的属性信息报告（关闭该端点方式：endpoints.configprops.enabled=false）
/env：该端点用来获取应用所有可用的环境属性报告，包括环境变量/jvm属性/应用的配置属性/命令行中的参数
/mappings：该端点用来返回所有spring mvc的控制器映射关系报告。
/info：该端点用来返回一些自定义的信息
度量指标类：
/metrics：该端点用来返回当前应用的各类重要度量指标，比如内存信息/线程信息/垃圾回收信息等
......


# Spring Cloud 简介
1.尽管springcloud带有cloud的字样，但它并不是云计算解决方案，而是再springboot基础上构建的，用于快速构建分布式系统的通用
模式的工具集。使用springcloud开发的应用程序非常适合在docker或者paas（例如cloud foundry）上部署，所以又叫云原生应用。
云原生可简单理解为面向云环境的软件构架。
2.springcloud的特点：
约定优于配置；
适用于各种环境。开发/部署在PC server或各种云环境（例如阿里云，aws等）均可；
隐藏了组件的复杂性，并提供声明式，无xml的配置方式；
开箱即用，快速启动；
轻量级的组件。springcloud整合的组件大多数比较轻量。例如Eureka，Zuul等待，都是各自领域轻量级的实现；
组件丰富，功能齐全。springcloud为微服务架构提供了非常完整的支持。例如：配置管理，服务发现，断路器，微服务网关等；
选型中立，丰富。例如：springcloud支持使用Eureka，Zookeeper或Consul实现服务发现；
灵活。springcloud的组成部分是解耦的，开发人员可按需求灵活挑选技术选型。
3.版本介绍：springcloud是一个综合项目，它包含很多的子项目。由于子项目也维护着自己的版本号，springcloud采用了这种版本命名方式
，从而避免与子项目的版本混淆。其中，英文单词叫做“release train”，Angel，Brixton，Camden等都是伦敦地铁站的名称，它们按照字母
顺序发行，可将其理解为主版本的演进。SR表示“Service Release"，一般表示Bug修复，在SR版本发布之前，会先发布一个Release版本，例如
Camden.Release
springcloud版本发布记录：https://github.com/spring-cloud/spring-cloud-release/releases
springcloud版本演进计划：https://github.com/spring-cloud/spring-cloud-release/milestones
springcloud和springboot版本兼容性：（可通过https://spring.io/projects/spring-cloud查看）
Angel版本基于springboot1.2.x构建，在一些场景下，与springboot1.3.x及以上版本不兼容
Brixton版本基于springboot1.3.x构建，也可使用1.4.x进行测试，与springboot1.2.x不兼容
Camden版本基于springboot1.4.x构建，也可使用1.5.x进行测试