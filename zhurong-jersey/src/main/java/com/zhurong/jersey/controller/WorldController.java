/**   
 * @Title: WorldController.java
 * @Package: com.zhurong.jersey.controller
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.jersey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 访问地址：http://localhost:9090/jersey/world/test
 * @author LZG
 * @date 2019/7/8
 */
@Controller
@RequestMapping("/world")
public class WorldController {

    @RequestMapping("/test")
    @ResponseBody
    public String world() {
        return "world";
    }

}