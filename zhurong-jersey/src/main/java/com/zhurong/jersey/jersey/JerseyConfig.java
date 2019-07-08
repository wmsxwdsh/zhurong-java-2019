/**   
 * @Title: JerseyConfig.java
 * @Package: com.essence.rstp.jersey
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jersey.jersey;

import com.zhurong.jersey.controller.HelloController;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @description: 
 * @author LZG
 * @date 2019/7/7
 */
@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloController.class);
    }

}