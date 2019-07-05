/**
 * @Title: LimitAspect.java
 * @Package: com.zhurong.interfacelimit.distributed.config
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.interfacelimit.distributed.config;

import com.zhurong.interfacelimit.distributed.annotation.RateLimit;
import com.zhurong.utils.general.IPAddressUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @description: 拦截器
 * @author LZG
 * @date 2019/7/5
 */
@Aspect
@Configuration
public class LimitAspect {

    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    @Autowired
    private RedisTemplate<String, Serializable> limitRedisTemplate;
    @Autowired
    private DefaultRedisScript<Number> redisLuaScript;

    @Around("execution(* com.zhurong.interfacelimit.distributed.controller ..*(..) )")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        RateLimit rateLimit = method.getAnnotation(RateLimit.class);

        if (rateLimit != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ipAddress = IPAddressUtil.getClientIPAddress(request);

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(ipAddress).append("-")
                .append(targetClass.getName()).append("- ")
                .append(method.getName()).append("-")
                .append(rateLimit.key());

            List<String> keys = Collections.singletonList(stringBuffer.toString());

            Number number = limitRedisTemplate.execute(redisLuaScript, keys, rateLimit.count(), rateLimit.time());

            if (number != null && number.intValue() != 0 && number.intValue() <= rateLimit.count()) {
                logger.info("限流时间段内访问第：{} 次", number.toString());
                return joinPoint.proceed();
            }

        } else {
            return joinPoint.proceed();
        }

        throw new RuntimeException("已经到设置限流次数");
    }

}