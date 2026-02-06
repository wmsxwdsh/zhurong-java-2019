package com.zhurong.utils.idgen;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

/**
 * 用 hutool 工具类，封装或使用 雪花算法
 *
 * @author LZG
 */
public class SnowFlakeHutool {
    /**
     * 终端ID，表示北京1下的 机器A、机器B ---- 谁发的号（默认 0-31）
     * 数据中心ID，表示地区：北京1、上海2 ---- 在哪发号（默认 0-31）
     * 最大节点数是 datacenterId × workerId = 32 × 32 = 1024 个发号节点
     * 最后 12 位是毫秒内的计数（12位的计数顺序号支持每个节点每毫秒产生4096个ID序号）
     */
    private long workerId = 0;
    private long datacenterId = 1;

    private Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);

    /**
     * 获取雪花ID
     * 雪花算法生成的是 64 位二进制整数（long）
     * 显示成十进制字符串后，通常是 19 位数字。
     * 例：2019670568055472135
     * （2019 6705 6805 5472 135）
     */
    public synchronized long snowflakeId() {
        return this.snowflake.nextId();
    }

    public static void main(String[] args) {
        SnowFlakeHutool snowFlakeDemo = new SnowFlakeHutool();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(snowFlakeDemo.snowflakeId());
            }, String.valueOf(i)).start();
        }
    }


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

}

