package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KungfuController {
	private final String PREFIX = "pages/";
	/**
	 * 欢迎页
     *  sos Error resolving template "welcome", template might not exist or might not be accessible by any of the configured Template Resolvers
     * 1. 在application.yml 中添加配置
     * spring：
     * thymeleaf：
     * prefix：classpath：/templates/
     *
     * 2. th:include引入公共模板时注意头部不要加"/"
     * <aside class="aside-md hidden-print hidden-xs" id="nav" th:include="base/menu :: aside"></aside>
     *
     * 3. @Controller改为@RestController 注解问题
     *
     * 4.return "/welcome";  中 必须要去掉 /  斜杠 。因为默认的路径是spring.thymeleaf.prefix=classpath:/templates/ 你再写/就多出一个斜杠了 。
	 */
	@GetMapping("/welcome")
	public String index() {
		return "welcome";
	}
	
	/**
	 * 登陆页
	 * @return
	 */
	@GetMapping("/myLogin")
	public String loginPage() {
		return PREFIX+"login";
	}
	
	
	/**
	 * level1页面映射
	 * @param path
	 * @return
	 */
	@GetMapping("/level1/{path}")
	public String level1(@PathVariable("path")String path) {
		return PREFIX+"level1/"+path;
	}
	
	/**
	 * level2页面映射
	 * @param path
	 * @return
	 */
	@GetMapping("/level2/{path}")
	public String level2(@PathVariable("path")String path) {
		return PREFIX+"level2/"+path;
	}
	
	/**
	 * level3页面映射
	 * @param path
	 * @return
	 */
	@GetMapping("/level3/{path}")
	public String level3(@PathVariable("path")String path) {
		return PREFIX+"level3/"+path;
	}


}
