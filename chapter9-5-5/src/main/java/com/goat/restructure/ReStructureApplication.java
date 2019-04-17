package com.goat.restructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ReStructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReStructureApplication.class, args);
	}
}
