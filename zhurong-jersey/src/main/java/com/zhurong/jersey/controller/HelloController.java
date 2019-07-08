/**   
 * @Title: HelloController.java
 * @Package: com.essence.rstp.controller
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jersey.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

/**
 * @description: 访问地址：http://localhost:9090/jersey/rest/hello/test
 * @author LZG
 * @date 2019/7/7
 */
@Component
@Path("/hello")
public class HelloController {

    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "hello";
    }

}