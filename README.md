# springCloud

# hello
1.添加hellocontroller和HelloTest，test中可以模拟接口调用

# 配置
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