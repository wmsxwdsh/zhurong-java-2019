package com.zhurong.interfacelimit.distributed.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    /**
     * @Description: 限流唯一标示
     * @return java.lang.String
     * @author LZG
     * @date 2019/7/5
     */
    String key() default "";

    /**
     * @Description: 限流时间
     * @return int
     * @author LZG
     * @date 2019/7/5
     */
    int time();

    /**
     * @Description: 限流次数
     * @return int
     * @author LZG
     * @date 2019/7/5
     */
    int count();
}
