package com.zhurong.myspring.controller;

import com.zhurong.myspring.vo.DatetimeVO;
import com.zhurong.utils.date.DateUtil;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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