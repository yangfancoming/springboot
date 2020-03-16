package com.goat.chapter005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 之前用户使用的是3个注解注解他们的main类。分别是@Configuration,@EnableAutoConfiguration,@ComponentScan
 * 由于这些注解一般都是一起使用，spring boot提供了一个统一的注解@SpringBootApplication
 * sos  @SpringBootApplication = (默认属性)@Configuration + @EnableAutoConfiguration + @ComponentScan
 *  @ComponentScan 作用：该注解默认就会装配标识了 @Controller，@Service，@Repository，@Component 注解的类到spring容器中
 * @Date:   2019/1/22
*/
//@SpringBootApplication 会自动扫描  所在类的同级包,以及子包里的所有BEAN，所以建议入口类放在最外层的包名下。
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
