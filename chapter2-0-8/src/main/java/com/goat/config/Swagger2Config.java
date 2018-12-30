package com.goat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


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
     * 项目启动后的访问地址：http://localhost:8208/8208/swagger-ui.html#/
     * 项目启动后的访问地址：http://localhost:8208/8208/doc.html
     */
    @Bean
    public Docket createRestApi() {
        //添加head参数start
        Parameter tokenParam = new ParameterBuilder()
                .name("x-access-token")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        Parameter languageParam = new ParameterBuilder()
                .name("Accept-Language")
                .description("国际化,例:zh_CN,en")
                .defaultValue(Locale.CHINA.toLanguageTag())
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        List<Parameter> pars = new ArrayList<>();
        pars.add(tokenParam);
        pars.add(languageParam);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(pars)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.goat.controller"))  // 指定基础包
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Myron","http://xxx.xxx.com/","xxxx@qq.com"); // 作者
        StringBuilder description = new StringBuilder();
        description .append("查看json格式:<a target='_blank' href='./v2/api-docs'>api-docs</a> <br>")
                    .append("接口文档下载:<a href='./swagger/markdown'>markdown</a>  ")
                    .append("<a href='./swagger/confluence'>confluence</a>  ")
                    .append("<a href='./swagger/html'>html</a> ")
                    .append("<a href='./swagger/json'>json</a> ");

        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs 并使用aop记录对于操作日志")  // 标题
                .description(description.toString()) // 简介/描述
                .termsOfServiceUrl("http://xxx.xxx.com/")
                .contact(contact)
                .version("1.0")  // 版本号
                .build();
    }
}