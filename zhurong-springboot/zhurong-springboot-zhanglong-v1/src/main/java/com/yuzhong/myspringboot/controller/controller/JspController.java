/**
 * @Title: JspController.java
 * @Package: com.yuzhong.myspringboot.controller
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.yuzhong.myspringboot.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * @author LZG
 * @description:
 * @date 2020年06月04日
 */
@Controller
public class JspController {

    @GetMapping("/jsp")
    public String result(Map<String, Object> model) {
        model.put("date", new Date());
        model.put("message", "hello world");
        return "result";
    }
}