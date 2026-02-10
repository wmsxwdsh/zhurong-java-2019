package com.zhurong.solution.beanvalidation.controller;

import com.zhurong.db.persistence.domain.TbBookInfo;
import com.zhurong.utils.response.InfoCoinResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBeanValidationController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public InfoCoinResponse saveTbBookInfo(@RequestBody @Validated TbBookInfo tbBookInfo) {
        return InfoCoinResponse.ok();
    }

}