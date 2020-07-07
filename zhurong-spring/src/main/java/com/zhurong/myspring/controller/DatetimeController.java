/**
 * @Title: DatetimeController.java
 * @Package: com.zhurong.myspring.controller
 * @author LZG, liuzg@12366.com
 * Copyright (c) 2020 http://www.12366.com
 */
package com.zhurong.myspring.controller;

import com.zhurong.myspring.vo.DatetimeVO;
import com.zhurong.utils.date.DateUtil;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author LZG
 * @date 2020年07月07日
 */
@RestController
@RequestMapping("/mydatetime")
public class DatetimeController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @PostMapping("/withdate")
    public String test(@RequestBody DatetimeVO datetimeVO) {
        System.out.println("------------------");
        String startTime = DateUtil.dateToString(datetimeVO.getStartTime(), DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        String endTime = DateUtil.dateToString(datetimeVO.getEndTime(), DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);

        return "startTime: " + startTime + "  <br> endTime: " + endTime;
    }


}