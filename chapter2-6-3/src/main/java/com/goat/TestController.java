package com.goat;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/welcome")
	public String index() { // 欢迎页
		return "welcome";
	}

}
