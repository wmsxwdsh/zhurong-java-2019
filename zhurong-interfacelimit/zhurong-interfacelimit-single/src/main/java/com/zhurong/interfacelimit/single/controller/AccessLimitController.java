package com.zhurong.interfacelimit.single.controller;

import com.zhurong.interfacelimit.single.service.AccessLimitService;
import com.zhurong.utils.response.edop.EdopResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 最快的方式是使用 RateLimit 类，但是这仅限制在单节点。
 * -- 如果是分布式系统，每个节点的 QPS 是一样的，请求量到服务接口那的话就是QPS * 节点数 了。
 * -- 所以这种方案在分布式的情况下不适用。
 * 2019/7/5
 */
@RestController
public class AccessLimitController {

    @Autowired
    private AccessLimitService accessLimitService;

    @RequestMapping("/access")
    public EdopResponse access() {
        //尝试获取令牌
        if (accessLimitService.tryAcquire()) {
            //模拟业务执行500毫秒
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return EdopResponse.ok("access success");
        }
        return EdopResponse.error("access limit");
    }

}