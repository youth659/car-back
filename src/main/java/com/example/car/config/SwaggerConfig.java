package com.example.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Swagger配置
 * <br>
 * created date 2021/4/24 11:54
 *
 * @author yh
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // 配置多个Swagger的bean，可以分组显示
//    @Bean
//    public Docket docket1(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
//    }
//    @Bean
//    public Docket docket2(){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
//    }

    // 配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示的Swagger环境
        //Profiles profiles = Profiles.of("dev");
        // 通过environment.acceptsProfiles判断是否处在自己设定的环境当中
//        boolean b = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("测试接口")
                // 是否启用Swagger
                .enable(true)
                // RequestHandlerSelectors配置要扫描接口的方式
                // withClassAnnotation 扫描类上的注解，参数是一个注解的反射对象，withMethodAnnotation 扫描方法上的注解
                // basePackage指定要扫描的包，any() 扫描全部，none() 不扫描
                .select().apis(RequestHandlerSelectors.basePackage("com.example.car.controller"))
                // 过滤扫描路径，只扫描路径为 /car/xxx 的接口
//                .paths(PathSelectors.ant("/car/**"))
                .build();
    }

    // 配置Swagger信息==apiInfo，源码只有构造没有set方法，只能通过这种方式绑定
    private ApiInfo apiInfo() {
        // 作者信息
        Contact concat = new Contact("杨神", "http://baidu.com", "123@126.com");

        return new ApiInfo(
                "杨神的SwaggerApi文档",
                "即使再小的帆也能远航",
                "v1.0",
                "http://baidu.com",
                concat,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
