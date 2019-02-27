/**   
 * @Title: JsonpController.java
 * @Package: com.zhurong.utils.web
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.web;

import com.zhurong.utils.general.StringUtil;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: jsonp的写法和用法
 * @author LZG
 * @date 2018/8/27
 */
public class JsonpController {

    @RequestMapping("/register")
    @ResponseBody
    public Object register(@RequestParam String userMail, @RequestParam String vCodeToken, @RequestParam String validateCode, @RequestParam String confirmUrl, @RequestParam String signInfo, String callback) {
        //ResponseVO responseVO = merchUserService.merchUserRegister(userMail, vCodeToken, validateCode, confirmUrl, signInfo);
        Object responseVO = null;
        if(StringUtil.isBlank(callback))
            return responseVO;

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(responseVO);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

}