/**   
 * @Title: RedisUtil.java
 * @Package: com.zhurong.distributedlock.redis.config
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.distributedlock.redis.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @description: RedisTemplate通用工具类
 * @author LZG
 * @date 2019/7/17
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    //解决spring boot redis序列化key-value乱码\xac\xed\x00\x05t\x00
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    //- - - - - - - - - - - - - - - - - - - - -  公共方法 - - - - - - - - - - - - - - - - - - - -

    /**
     * @Description: 给一个指定的 key 值附加过期时间
     * @param key
     * @param time
     * @return boolean
     * @author LZG
     * @date 2019/7/17
     */
    public boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * @Description: 根据key 获取过期时间
     * @param key
     * @return long
     * @author LZG
     * @date 2019/7/17
     */
    public long getTime(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * @Description: 判断key是否存在
     * @param key
     * @return boolean
     * @author LZG
     * @date 2019/7/17
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * @Description: 移除指定key 的过期时间
     * @param key
     * @return boolean
     * @author LZG
     * @date 2019/7/17
     */
    public boolean persist(String key) {
        return redisTemplate.boundValueOps(key).persist();
    }

    //- - - - - - - - - - - - - - - - - - - - -  String类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * @Description: 根据key获取值
     * @param key
     * @return java.lang.Object
     * @author LZG
     * @date 2019/7/17
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * @Description: 将值放入缓存
     * @param key
     * @param value
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * @Description: 将值放入缓存并设置时间
     * @param key
     * @param value
     * @param time 时间(秒) -1为无期限
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void set(String key, String value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * @Description: 批量添加 key (重复的键会覆盖)
     * @param keyAndValue
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void batchSet(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSet(keyAndValue);
    }

    /**
     * @Description:  批量添加 key-value 只有在键不存在时,才添加
     * @param keyAndValue  map 中只要有一个key存在,则全部不添加
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void batchSetIfAbsent(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSetIfAbsent(keyAndValue);
    }

    /**
     * @Description: 对一个 key-value 的值进行加减操作
     *          -- 如果该 key 不存在 将创建一个key 并赋值该 number
     *          -- 如果 key 存在,但 value 不是长整型 ,将报错
     * @param key
     * @param number
     * @return java.lang.Long
     * @author LZG
     * @date 2019/7/17
     */
    public Long increment(String key, long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    /**
     * @Description: 对一个 key-value 的值进行加减操作
     *          -- 如果该 key 不存在, 将创建一个key 并赋值该 number
     *          -- 如果 key 存在,但 value 不是 纯数字, 将报错
     * @param key
     * @param number
     * @return java.lang.Double
     * @author LZG
     * @date 2019/7/17
     */
    public Double increment(String key, double number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    //- - - - - - - - - - - - - - - - - - - - -  set类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * @Description: 将数据放入set缓存
     * @param key
     * @param value
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void sSet(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    /**
     * @Description: 根据key获取Set
     * @param key
     * @return java.util.Set<java.lang.Object>
     * @author LZG
     * @date 2019/7/17
     */
    public Set<Object> members(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * @Description: 随机获取变量中指定个数的元素
     * @param key
     * @param count
     * @return java.util.List<java.lang.Object>
     * @author LZG
     * @date 2019/7/17
     */
    public List<Object> randomMembers(String key, long count) {
        return redisTemplate.opsForSet().randomMembers(key, count);
    }

    /**
     * @Description: 随机获取变量中的元素
     * @param key
     * @return java.lang.Object
     * @author LZG
     * @date 2019/7/17
     */
    public Object randomMember(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * @Description: 弹出变量中的元素
     * @param key
     * @return java.lang.Object
     * @author LZG
     * @date 2019/7/17
     */
    public Object pop(String key) {
        return redisTemplate.opsForSet().pop("setValue");
    }

    /**
     * @Description: 获取变量中值的长度
     * @param key
     * @return long
     * @author LZG
     * @date 2019/7/17
     */
    public long size(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * @Description: 根据value从一个set中查询,是否存在
     * @param key
     * @param value
     * @return boolean
     * @author LZG
     * @date 2019/7/17
     */
    public boolean sHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * @Description: 检查给定的元素是否在变量中
     * @param key
     * @param obj
     * @return boolean
     * @author LZG
     * @date 2019/7/17
     */
    public boolean isMember(String key, Object obj) {
        return redisTemplate.opsForSet().isMember(key, obj);
    }

    /**
     * @Description: 转移变量的元素值到目的变量
     * @param key
     * @param value
     * @param destKey
     * @return boolean
     * @author LZG
     * @date 2019/7/17
     */
    public boolean move(String key, String value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    /**
     * @Description: 批量移除set缓存中元素
     * @param key
     * @param values
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void remove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * @Description: 通过给定的key求2个set变量的差值
     * @param key
     * @param destKey
     * @return java.util.Set<java.util.Set>
     * @author LZG
     * @date 2019/7/17
     */
    public Set<Set> difference(String key, String destKey) {
        return redisTemplate.opsForSet().difference(key, destKey);
    }


    //- - - - - - - - - - - - - - - - - - - - -  hash类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * @Description: 加入缓存
     * @param key
     * @param map
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void add(String key, Map<String, String> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * @Description: 获取 key 下的 所有 hashkey 和 value
     * @param key
     * @return java.util.Map<java.lang.Object,java.lang.Object>
     * @author LZG
     * @date 2019/7/17
     */
    public Map<Object, Object> getHashEntries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * @Description: 验证指定 key 下 有没有指定的 hashkey
     * @param key
     * @param hashKey
     * @return boolean
     * @author LZG
     * @date 2019/7/17
     */
    public boolean hashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * @Description: 获取指定key的值string
     * @param key
     * @param key2
     * @return java.lang.String
     * @author LZG
     * @date 2019/7/17
     */
    public String getMapString(String key, String key2) {
        return redisTemplate.opsForHash().get("map1", "key1").toString();
    }

    /**
     * @Description: 获取指定的值Int
     * @param key
     * @param key2
     * @return java.lang.Integer
     * @author LZG
     * @date 2019/7/17
     */
    public Integer getMapInt(String key, String key2) {
        return (Integer) redisTemplate.opsForHash().get("map1", "key1");
    }

    /**
     * @Description: 弹出元素并删除
     * @param key
     * @return java.lang.String
     * @author LZG
     * @date 2019/7/17
     */
    public String popValue(String key) {
        return redisTemplate.opsForSet().pop(key).toString();
    }

    /**
     * @Description: 删除指定 hash 的 HashKey
     * @param key
     * @param hashKeys
     * @return java.lang.Long 删除成功的 数量
     * @author LZG
     * @date 2019/7/17
     */
    public Long delete(String key, String... hashKeys) {
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    /**
     * @Description: 给指定 hash 的 hashkey 做增减操作
     * @param key
     * @param hashKey
     * @param number
     * @return java.lang.Long
     * @author LZG
     * @date 2019/7/17
     */
    public Long increment(String key, String hashKey, long number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    /**
     * @Description: 给指定 hash 的 hashkey 做增减操作
     * @param key
     * @param hashKey
     * @param number
     * @return java.lang.Double
     * @author LZG
     * @date 2019/7/17
     */
    public Double increment(String key, String hashKey, Double number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    /**
     * @Description: 获取 key 下的 所有 hashkey 字段
     * @param key
     * @return java.util.Set<java.lang.Object>
     * @author LZG
     * @date 2019/7/17
     */
    public Set<Object> hashKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * @Description: 获取指定 hash 下面的 键值对 数量
     * @param key
     * @return java.lang.Long
     * @author LZG
     * @date 2019/7/17
     */
    public Long hashSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    //- - - - - - - - - - - - - - - - - - - - -  list类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * @Description: 在变量左边添加元素值
     * @param key
     * @param value
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * @Description: 获取集合指定位置的值
     * @param key
     * @param index
     * @return java.lang.Object
     * @author LZG
     * @date 2019/7/17
     */
    public Object index(String key, long index) {
        return redisTemplate.opsForList().index("list", 1);
    }

    /**
     * @Description: 获取指定区间的值
     * @param key
     * @param start
     * @param end
     * @return java.util.List<java.lang.Object>
     * @author LZG
     * @date 2019/7/17
     */
    public List<Object> range(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * @Description: 把最后一个参数值放到指定集合的第一个出现中间参数的前面，如果中间参数值存在的话。
     * @param key
     * @param pivot
     * @param value
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void leftPush(String key, String pivot, String value) {
        redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    /**
     * @Description: 向左边批量添加参数元素
     * @param key
     * @param values
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void leftPushAll(String key, String... values) {
//        redisTemplate.opsForList().leftPushAll(key,"w","x","y");
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * @Description: 向集合最右边添加元素
     * @param key
     * @param value
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void leftPushAll(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * @Description: 向左边批量添加参数元素
     * @param key
     * @param values
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void rightPushAll(String key, String... values) {
//        redisTemplate.opsForList().leftPushAll(key,"w","x","y");
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * @Description: 以集合方式向右边添加元素
     * @param key
     * @param values
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void rightPushAll(String key, Collection values) {
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * @Description: 向已存在的集合中添加元素
     * @param key
     * @param value
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void rightPushIfPresent(String key, Object value) {
        redisTemplate.opsForList().rightPushIfPresent(key, value);
    }

    /**
     * @Description: 向已存在的集合中添加元素
     * @param key
     * @return long
     * @author LZG
     * @date 2019/7/17
     */
    public long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * @Description: 移除集合中的左边第一个元素
     * @param key
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void leftPop(String key) {
        redisTemplate.opsForList().leftPop(key);
    }

    /**
     * @Description: 移除集合中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     * @param key
     * @param timeout
     * @param unit
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void leftPop(String key, long timeout, TimeUnit unit) {
        redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    /**
     * @Description: 移除集合中右边的元素
     * @param key
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void rightPop(String key) {
        redisTemplate.opsForList().rightPop(key);
    }

    /**
     * @Description: 移除集合中右边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     * @param key
     * @param timeout
     * @param unit
     * @return void
     * @author LZG
     * @date 2019/7/17
     */
    public void rightPop(String key, long timeout, TimeUnit unit) {
        redisTemplate.opsForList().rightPop(key, timeout, unit);
    }

}