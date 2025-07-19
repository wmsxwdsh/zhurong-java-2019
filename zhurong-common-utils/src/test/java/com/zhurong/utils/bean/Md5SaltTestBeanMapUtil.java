/**   
 * @Title: TestBeanMapUtil.java
 * @Package: com.zhurong.utils.mapbean
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.bean;

import java.util.Map;
import org.junit.Test;

/**
 * @description: 
 * @author LZG
 * @date 2018/10/26
 */
public class Md5SaltTestBeanMapUtil {

    @Test
    public void test1(){

        //从bean
        MerchOrderCharge merchOrderCharge = new MerchOrderCharge();
        merchOrderCharge.setOrder_no("order_no_10001");
        merchOrderCharge.setChannel("WX-H5-PAY");
        merchOrderCharge.setCurrency("cny");
        merchOrderCharge.setAmount(1);
        merchOrderCharge.setSubject("测试订单");

        //主bean
        BizRequest bizRequest = new BizRequest();
        bizRequest.setApp_id("app_id_88888");
        bizRequest.setCharset("UTF-8");
        bizRequest.setClient_ip("192.168.10.21");
        bizRequest.setDevice("android");
        bizRequest.setCharge(merchOrderCharge);

        //bean转换成为map
        Map<String, Object> resultMap = BeanMapUtil.object2Map(bizRequest);
        System.out.println(resultMap);

        //map转换成bean
        BizRequest resultBean = BeanMapUtil.map2Object(BizRequest.class, resultMap);
        System.out.println(resultBean);

    }


}