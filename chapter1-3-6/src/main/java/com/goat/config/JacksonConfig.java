package com.goat.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;


@Configuration
public class JacksonConfig {
	@Bean
	public ObjectMapper getObjectMapper(){
		ObjectMapper mapper = new ObjectMapper();
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); // 功能同配置文件  这里先不配置
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); // 功能同配置文件  这里先不配置
      mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));//解决时区差8小时问题
		return mapper;
	}
}

/**
 * mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); 配置后 访问 http://localhost:8136/consumer/test1  返回 结果
 [{"id":5,"col1":"sdf","col2":4313412,"info":null,"createdTime":"2018-12-12","lastTime":"2018-12-12","birthday1":"2018-12-12","birthday2":"20:16:14","birthday3":"2018-12-12 20:16:15"}]

 * mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));   配置后 访问 http://localhost:8136/consumer/test1  返回 结果
 [{"id":5,"col1":"sdf","col2":4313412,"info":null,"createdTime":"2018-12-12 20:16:15","lastTime":"2018-12-12 20:16:15","birthday1":"2018-12-12","birthday2":"20:16:14","birthday3":"2018-12-12 20:16:15"}]

 *  以上两种日期格式都不配置 访问 http://localhost:8136/consumer/test1  返回 结果
 [{"id":5,"col1":"sdf","col2":4313412,"info":null,"createdTime":1544616975000,"lastTime":1544616975000,"birthday1":"2018-12-12","birthday2":"20:16:14","birthday3":"2018-12-12 20:16:15"}]

  *  sos  JavaBean 和 application.yml  这些全局日期格式配置 并不会 覆盖掉  @JsonFormat(pattern = "HH:mm:ss") 单个属性的配置

 */