package com.goat.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class JacksonConfig {
	@Bean
	public ObjectMapper getObjectMapper(){
		ObjectMapper mapper = new ObjectMapper();
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); // 功能同配置文件  这里先不配置
//      mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));//解决时区差8小时问题
		return mapper;
	}
}
