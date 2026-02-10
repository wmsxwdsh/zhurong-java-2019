package com.zhurong.solution.sign.client.controller;

import com.zhurong.utils.sign.SignValidateUtil;
import com.zhurong.utils.common.HttpClientUtil;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/signClientController")
public class SignClientController {

    //浏览器请求地址：http://localhost:8080/signClient/signClientController/signTest
    @RequestMapping("/signTest")
    @ResponseBody
    public String signTest(HttpServletRequest request) {

        String signServerUrl = "http://localhost:9090/signServer/signServerController/verifySignTest";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountId", "admin");
        paramMap.put("name", "刘德华");
        paramMap.put("device", "android");
        paramMap.put("comment", "是个帅哥");

        SignValidateUtil.md5Sign(paramMap);

        String s = HttpClientUtil.doPostExpand(signServerUrl, paramMap); //支持中文
        return s;
    }
}