package com.zhurong.distributedlock.redis.config;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Redis分布式锁，适用于Redis单节点部署。
 * -- 具体内容参考笔记
 * 2019/7/5
 */
@Service
public class RedisLockUtil {

    @Autowired
    private JedisFactory jedisFactory;

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final int expireTime = 10000;

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁 redis key
     * @param lockId 锁值 redis key对应value
     * @return boolean 是否获取成功
     */
    public boolean tryGetDistributedLock(String lockKey, String lockId) {
        Jedis jedis = jedisFactory.getJedis();
        String result = jedis.set(lockKey, lockId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @return boolean 是否释放成功
     */
    public boolean releaseDistributedLock(String lockKey, String lockId) {
        Jedis jedis = jedisFactory.getJedis();
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(lockId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

}