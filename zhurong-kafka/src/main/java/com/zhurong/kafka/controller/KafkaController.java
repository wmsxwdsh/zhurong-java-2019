/**
 * @Title: KafkaController.java
 * @Package: com.zhurong.kafka
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.kafka.controller;

import com.zhurong.kafka.service.KafkaService;
import com.zhurong.utils.date.DateUtil;
import com.zhurong.utils.response.edop.EdopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author LZG
 * @date 2019/7/18
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @RequestMapping("/test")
    public EdopResponse test() {
        kafkaService.sendMessage();

        return EdopResponse.ok("test success", DateUtil.getNow(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
    }

}