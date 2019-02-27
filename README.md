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
