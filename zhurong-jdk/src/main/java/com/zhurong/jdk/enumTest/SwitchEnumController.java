/**   
 * @Title: SwitchEnumController.java
 * @Package: com.zhurong.jdk.enumTest
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.jdk.enumTest;

import com.zhurong.utils.general.StringUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 
 * @author LZG
 * @date 2018/11/23
 */
@RestController
public class SwitchEnumController {

    //1、通过HttpServletRequest获取参数
    @RequestMapping("/switchEnumTest1")
    public String switchEnumTest1(HttpServletRequest request) {
        String clientBizTypeStr = request.getParameter("bizType");
        if(StringUtil.isBlank(clientBizTypeStr)) {
            return "bizType不能为空";
        }

        BizType clientBizType = BizType.getByValue(clientBizTypeStr);
        switch (clientBizType) {

            case USER_WITHDRAW:
                return "USER_WITHDRAW";
            case BUY_AD:
                return "BUY_AD";
            case BUY_CITY:
                return "BUY_CITY";
            default:
                return "default";
        }

    }

    //2、restful风格
    //@PathVariable不能为空，不能设置默认值，因为null对于url是无意义的。
    //如果参数确实可能为空，需要默认值，可以使用@RequestParams。
    @RequestMapping("/switchEnumTest2/{bizType}")
    public String switchEnumTest2(@PathVariable String bizType ) {

        BizType clientBizType = BizType.getByValue(bizType);
        switch (clientBizType) {

            case USER_WITHDRAW:
                return "USER_WITHDRAW";
            case BUY_AD:
                return "BUY_AD";
            case BUY_CITY:
                return "BUY_CITY";
            default:
                return "default";
        }
    }

    //3、RequestParam
    @RequestMapping("/switchEnumTest3")
    public String switchEnumTest3(@RequestParam(required = false, defaultValue = "11") String bizType) {

        BizType clientBizType = BizType.getByValue(bizType);
        switch (clientBizType) {

            case USER_WITHDRAW:
                return "USER_WITHDRAW";
            case BUY_AD:
                return "BUY_AD";
            case BUY_CITY:
                return "BUY_CITY";
            default:
                return "default";
        }
    }

}