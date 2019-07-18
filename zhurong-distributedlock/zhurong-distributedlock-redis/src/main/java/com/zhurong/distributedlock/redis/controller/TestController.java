/**
 * @Title: TestController.java
 * @Package: com.zhurong.distributedlock.redis.controller
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.distributedlock.redis.controller;

import com.zhurong.distributedlock.redis.config.RedisLockUtil;
import com.zhurong.distributedlock.redis.config.RedisUtil;
import com.zhurong.utils.idgen.UuidUtil;
import com.zhurong.utils.response.edop.EdopResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 参考资料 https://my.oschina.net/u/3452433/blog/3004997
 * @author LZG
 * @date 2019/7/5
 */
@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisLockUtil redisLockUtil;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public EdopResponse test() {
        String lockKey = "userid:anglelababy";

        //锁id（必须拥有此id才能释放锁）
        String lockId = UuidUtil.get32UUIDStr();

        try {
            //占用锁
            boolean occupy = redisLockUtil.tryGetDistributedLock(lockKey, lockId);
            if (occupy) {
                //程序执行
                logger.info("抢到了锁，程序执行了……");
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            redisLockUtil.releaseDistributedLock(lockKey, lockId);
        }

        //问题：occupy为false，即没有抢到锁，就什么都不执行?!
        return EdopResponse.ok("执行完毕！");
    }

    @RequestMapping("/testRedisTemplate")
    public EdopResponse testRedisTemplate() {
        redisUtil.set("hello", "world", 5000);
        return EdopResponse.ok("testRedisTemplate测试完毕！");
    }

}