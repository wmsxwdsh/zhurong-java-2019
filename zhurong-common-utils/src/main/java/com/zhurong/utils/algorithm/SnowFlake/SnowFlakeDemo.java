package com.zhurong.utils.algorithm.SnowFlake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

/**
 * 用 hutool 工具类，封装或使用 雪花算法
 *
 * @author LZG
 */
public class SnowFlakeDemo {
    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowFlake = IdUtil.createSnowflake(workerId, datacenterId);

    // 这里需要引入 j2ee 的包
//    @PostConstruct
    public void init() {
        try {
            // 将网络 ip 转换成 long
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取雪花ID
     * @return
     */
    public synchronized long snowflakeId() {
        return this.snowFlake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {
        SnowFlakeDemo snowFlakeDemo = new SnowFlakeDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(snowFlakeDemo.snowflakeId());
            }, String.valueOf(i)).start();
        }
    }
}

