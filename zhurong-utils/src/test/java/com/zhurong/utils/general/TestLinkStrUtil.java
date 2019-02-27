/**
 * @Title: TestLinkStrUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @description: LinkStrUtil测试类
 * @author LZG
 * @date 2018/8/27
 */
public class TestLinkStrUtil {

    /**
     * @Description: 两层测试(主Map里的某个key的值是从Map, 用得最多)
     * @return void
     * @author LZG
     * @date 2018/8/27
     */
    @Test
    public void testTwoLevel() {
        //订单数据(从map)
        Map<String, Object> merchOrderChargeMap = new HashMap<String, Object>();
        merchOrderChargeMap.put("order_no", "order_no_10001");
        merchOrderChargeMap.put("channel", "WX-H5-PAY");
        merchOrderChargeMap.put("currency", "cny");
        merchOrderChargeMap.put("amount", 1);
        merchOrderChargeMap.put("subject", "测试订单");

        //业务请求数据(包含订单数据，主map)
        Map<String, Object> bizRequestMap = new HashMap<String, Object>();
        bizRequestMap.put("app_id", "app_id_88888");
        bizRequestMap.put("charset", "UTF-8");
        bizRequestMap.put("client_ip", "192.168.10.21");
        bizRequestMap.put("device", "android");
        bizRequestMap.put("charge", merchOrderChargeMap);

        String createLinkString = LinkStrUtil.createLinkString(bizRequestMap, true);
        System.out.println(createLinkString);
        /*
         * 输出结果：
		 * app_id=app_id_88888&
		 * charge={amount=1&channel=WX-H5-PAY&currency=cny&order_no=order_no_10001&subject=测试订单}&
		 * charset=UTF-8&client_ip=192.168.10.21&device=android
		 */
    }

    /**
     * @Description: 三层测试(主Map里的某个key的值是个从Map, 从Map里key的某个值是第3个Map)
     *      --测试用例源于中数下订单请求报文
     * @return void
     * @author LZG
     * @date 2018/8/27
     */
    @Test
    public void testThreeLevel() {
        //订单的扩展数据(第3个Map)
        Map<String, Object> extraOfChargeMap = new HashMap<String, Object>();
        extraOfChargeMap.put("return_url", "http://www.baidu.com/returnUrl.html");
        extraOfChargeMap.put("receiverInfo", "北京市海淀区中关村e世界");

        //订单数据(包括订单的扩展数据),从Map
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("order_no", "test1470654170170");
        chargeMap.put("channel", "cashier_pay");
        chargeMap.put("currency", "cny");
        chargeMap.put("amount", 100);
        chargeMap.put("subject", "测试商品");
        chargeMap.put("body", null); //null不参与签名
        chargeMap.put("optional", "aaa=111,bbb=222,ccc=333");
        chargeMap.put("notify_url", "http://www.baidu.com/notifyUrl.html");
        chargeMap.put("time_expire", "201605121430");
        chargeMap.put("extra", extraOfChargeMap);

        //业务请求数据(包含订单数据),主Map
        Map<String, Object> bizRequestMap = new HashMap<String, Object>();
        bizRequestMap.put("app_id", "0MRLuXgRvHCXGfxIvbF6bA");
        bizRequestMap.put("charset", "UTF-8");
        bizRequestMap.put("timestamp", "20160512143030");
        bizRequestMap.put("client_ip", "127.0.0.1");
        bizRequestMap.put("device", "PC");
        bizRequestMap.put("live_mode", true);
        bizRequestMap.put("version", "V2.1.1");
        bizRequestMap.put("sign_type", "md5");
        bizRequestMap.put("sign_info", "ef288a7754b0460e9b93e79d83f0e0e6");
        bizRequestMap.put("sdk_mark", "sdk v1.1.16");
        bizRequestMap.put("charge", chargeMap);

        String createLinkString = LinkStrUtil.createLinkString(bizRequestMap, true);
        System.out.println(createLinkString);
        /**
         * 输出结果：
         * app_id=0MRLuXgRvHCXGfxIvbF6bA&
         * charge={amount=100&channel=cashier_pay&currency=cny&
         *         extra={receiverInfo=北京市海淀区中关村e世界&
         *              return_url=http://www.baidu.com/returnUrl.html}&
         *         notify_url=http://www.baidu.com/notifyUrl.html&optional=aaa=111,bbb=222,ccc=333&
         *         order_no=test1470654170170&subject=测试商品&time_expire=201605121430
         *         }&
         * charset=UTF-8&client_ip=127.0.0.1&device=PC&live_mode=true&
         * sdk_mark=sdk v1.1.16&timestamp=20160512143030&version=V2.1.1
         */
    }

}