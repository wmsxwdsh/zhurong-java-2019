package com.zhurong.springboot.test.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.zhurong.springboot.test"})
public class Swagger2Config {

    // 设置默认TOKEN，方便测试
    private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJjcmVhdGlvblRpbWVzdGFtcFwiOjE1MDkzMjg4MzQ1MDksXCJtZW1iZXJJZFwiOjkyMzczMjk2NjM5NDMxMDY1OCxcIm9yZ2FuaXphdGlvbklkXCI6MTEzNTc4NDI2NTUzMDYyNDAwMSxcInBlcm1pc3Npb25fbGV2ZWxcIjpcIlNVUEVSX1NZU1RFTV9MRVZFTFwiLFwidXNlcklkXCI6MX0iLCJpYXQiOjE1NzEwNDQwMTh9.ZeI7V4RfvPgFtfu05HPIDaD3OYmUzn0N8lWNxBqsujH2gfwovphtHEPnxO0xqsomxJBtRC0xPXYqBIZZ9COFNg";

    @Bean
    public Docket orderApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("token").description("令牌").defaultValue(TOKEN).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("operation-service-api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error")))//过滤的接口
                .build()
                .globalOperationParameters(pars)
                .apiInfo(orderApiInfo2());

        return docket;
    }

    private ApiInfo orderApiInfo() {
        return new ApiInfoBuilder() //
                .title("springboot利用swagger构建api文档") //
                .description("简单优雅的restfun风格") //
                .termsOfServiceUrl("https://github.com/springfox/springfox-demos") //
                .version("1.0") //
                .build();
    }

    private ApiInfo orderApiInfo2() {
        ApiInfo apiInfo = new ApiInfo("通用业务模型",//大标题
                "1、实现了业务模型在线自定义<br>2、实现通用业务模型的CRUD操作",//小标题
                "1.0",//版本
                "http://localhost:8580/operation/swagger-ui.html",
                "David",//作者
                "易桥",//链接显示文字
                "http://www.12366.com/"//网站链接
        );
        return apiInfo;
    }

}