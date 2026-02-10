package com.yuzhong.myspringboot.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class JspController {

    @GetMapping("/jsp")
    public String result(Map<String, Object> model) {
        model.put("date", new Date());
        model.put("message", "hello world");
        return "result";
    }
}