package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KungfuController {
	private final String PREFIX = "pages/";

	@GetMapping("/welcome")
	public String index() { // 欢迎页
		return "welcome";
	}
	
	@GetMapping("/login")
	public String loginPage() { // 登陆页
		return PREFIX+"login";
	}

	@GetMapping("/level1/{path}")
	public String level1(@PathVariable("path")String path) { // level1页面映射
		return PREFIX+"level1/"+path;
	}
	

	@GetMapping("/level2/{path}")
	public String level2(@PathVariable("path")String path) { // level2页面映射
		return PREFIX+"level2/"+path;
	}

	@GetMapping("/level3/{path}")
	public String level3(@PathVariable("path")String path) { //  level3页面映射
		return PREFIX+"level3/"+path;
	}


}
