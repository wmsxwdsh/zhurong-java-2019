/**
 * @Title: SignServerController.java
 * @Package: com.zhurong.solution.sign.server.controller
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.solution.sign.server.controller;

import com.zhurong.solution.sign.server.annotation.VerifySign;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 签名服务端controller
 * @author LZG
 * @date 2019/3/4
 */
@Controller
@RequestMapping("/signServerController")
public class SignServerController {

    @RequestMapping("/verifySignTest")
    @ResponseBody
    @VerifySign
    public String verifySignTest(HttpServletRequest request) {

        String accountId = request.getParameter("code");
        String name = request.getParameter("name");
        String device = request.getParameter("device");
        String comment = request.getParameter("comment");

        //业务逻辑处理……

        return "HelloWorld";
    }

}