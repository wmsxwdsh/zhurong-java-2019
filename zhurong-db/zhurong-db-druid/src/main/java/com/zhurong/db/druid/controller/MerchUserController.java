package com.zhurong.db.druid.controller;

import com.zhurong.db.druid.service.MerchUserService;
import com.zhurong.db.persistence.domain.MerchUser;
import com.zhurong.utils.gen.ChineseNameGen;
import com.zhurong.utils.gen.EmailGen;
import com.zhurong.utils.gen.MobileNumberGen;
import com.zhurong.utils.idgen.UuidUtil;
import com.zhurong.utils.response.InfoCoinResponse;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 2019/3/7
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
            .createTime(new Date())
            .build();
        merchUserService.insert(merchUser);

        return InfoCoinResponse.ok().getMsg();
    }

}