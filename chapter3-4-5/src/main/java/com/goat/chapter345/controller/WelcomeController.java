package com.goat.chapter345.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    // http://localhost:8345/welcome
	@GetMapping("/welcome")
	public String index() { // 欢迎页
		return "welcome";
	}

}
