package com.goat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 主要用途：开启在线接口文档和添加相关配置
 *
 * @author yizhiwazi
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 添加摘要信息(Docket)
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，
     * 并产生文档内容（除了被@ApiIgnore指定的请求）
     * 项目启动后的访问地址： http://localhost:8611/swagger-ui.html
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：111通信_协议管理管理系统_接口文档")
                        .description("描述：用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
                        .contact(new Contact("山羊来了","www.baidu.com","642744551@qq.com"))
                        .version("版本号:1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.goat.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}