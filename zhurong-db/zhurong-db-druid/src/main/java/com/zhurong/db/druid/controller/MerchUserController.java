/**
 * @Title: MerchUserController.java
 * @Package: com.zhurong.db.druid.controller
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.db.druid.controller;

import com.zhurong.db.druid.service.MerchUserService;
import com.zhurong.db.persistence.domain.MerchUser;
import com.zhurong.utils.gen.ChineseNameGen;
import com.zhurong.utils.gen.EmailGen;
import com.zhurong.utils.gen.MobileNumberGen;
import com.zhurong.utils.idgen.UuidUtil;
import com.zhurong.utils.response.InfoCoinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author LZG
 * @date 2019/3/7
 */
@Controller
@RequestMapping("/merchUserAction")
public class MerchUserController {

    @Autowired
    private MerchUserService merchUserService;

    @RequestMapping("/testInsert")
    @ResponseBody
    public String testInsertMerchUser() {

        MerchUser merchUser = new MerchUser.Builder().id(UuidUtil.get32UUIDStr())
            .merchUserName(ChineseNameGen.generate())
            .merchUserEmail(EmailGen.generate()).merchUserMobile(MobileNumberGen.generate())
            .build();
        merchUserService.insert(merchUser);

        return InfoCoinResponse.ok().getMsg();
    }

}