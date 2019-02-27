/**   
 * @Title: TestMapBeanUtil.java
 * @Package: com.zhurong.utils.mapbeanconvert
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.mapbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * @description: MapBeanUtil测试类
 *      --最主要的就是testMapToBean方法(map里包含map如何转换成bean)
 * @author LZG
 * @date 2018/8/27
 */
public class TestMapBeanUtil {

    //Bean转换成Map测试
    @Test
    public void testBeanToMap() {
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

        Map<String, Object> beanToMap = MapBeanUtil.beanToMap(bizRequest);
        System.out.println(beanToMap);
		/*输出结果如下：
		 * {charset=UTF-8,
		 * charge=MerchOrderCharge [order_no=order_no_10001, channel=WX-H5-PAY,
		 *                          currency=cny, amount=1, subject=测试订单],
		 * client_ip=192.168.10.21, app_id=app_id_88888, device=android}
		 */
    }

    //Map转换成Bean测试
    @Test
    public void testMapToBean() {
        //从Map
        Map<String, Object> merchOrderChargeMap = new HashMap<String, Object>();
        merchOrderChargeMap.put("order_no", "order_no_10001");
        merchOrderChargeMap.put("channel", "WX-H5-PAY");
        merchOrderChargeMap.put("currency", "cny");
        merchOrderChargeMap.put("amount", 1);
        merchOrderChargeMap.put("subject", "测试订单");

        //主Map
        Map<String, Object> bizRequestMap = new HashMap<String, Object>();
        bizRequestMap.put("app_id", "app_id_88888");
        bizRequestMap.put("charset", "UTF-8");
        bizRequestMap.put("client_ip", "192.168.10.21");
        bizRequestMap.put("device", "android");
        //bizRequestMap.put("charge", merchOrderChargeMap);

        //纯map转换成bean
        MerchOrderCharge merchOrderCharge = new MerchOrderCharge();
        MerchOrderCharge mapToBean = MapBeanUtil.mapToBean(merchOrderChargeMap, merchOrderCharge);
        System.out.println(mapToBean);
        System.out.println(mapToBean.getSubject());

        /**
         * 非纯map(map里某个属性也是一个bean)转换成bean
         * (特殊说明：主Map在put从Map的属性值的时候,需要先将从Map转换成bean)
         */
        BizRequest bizRequest = new BizRequest();
        bizRequestMap.put("charge", mapToBean);
        BizRequest bizRequestBean = MapBeanUtil.mapToBean(bizRequestMap, bizRequest);
        System.out.println(bizRequestBean);
        System.out.println(bizRequestBean.getDevice());
    }


    // 将List<T>转换为List<Map<String, Object>>
    @Test
    public void testObjectsToMaps() {

        //订单1
        MerchOrderCharge merchOrderCharge1 = new MerchOrderCharge();
        merchOrderCharge1.setOrder_no("order_no_10001");
        merchOrderCharge1.setChannel("WX-H5-PAY");
        merchOrderCharge1.setCurrency("cny");
        merchOrderCharge1.setAmount(1);
        merchOrderCharge1.setSubject("微信h5订单");

        //订单2
        MerchOrderCharge merchOrderCharge2 = new MerchOrderCharge();
        merchOrderCharge2.setOrder_no("order_no_22222");
        merchOrderCharge2.setChannel("JD-WAP-PAY");
        merchOrderCharge2.setCurrency("cny");
        merchOrderCharge2.setAmount(2);
        merchOrderCharge2.setSubject("京东订单");

        //订单1、订单2都添加到List里
        List<MerchOrderCharge> merchOrderChargeList = new ArrayList<MerchOrderCharge>();
        merchOrderChargeList.add(merchOrderCharge1);
        merchOrderChargeList.add(merchOrderCharge2);

        List<Map<String, Object>> objectsToMaps = MapBeanUtil.objectsToMaps(merchOrderChargeList);
        System.out.println(objectsToMaps);
        /**
         * 输出结果：
         * [{amount=1, subject=微信h5订单, channel=WX-H5-PAY, order_no=order_no_10001, currency=cny},
         *  {amount=2, subject=京东订单, channel=JD-WAP-PAY, order_no=order_no_22222, currency=cny}]
         */
    }

    // 将List<Map<String,Object>>转换为List<T>
    @Test
    public void testMapsToObjects() {
        //订单1的Map
        Map<String, Object> merchOrderChargeMap1 = new HashMap<String, Object>();
        merchOrderChargeMap1.put("order_no", "order_no_10001");
        merchOrderChargeMap1.put("channel", "WX-H5-PAY");
        merchOrderChargeMap1.put("currency", "cny");
        merchOrderChargeMap1.put("amount", 1);
        merchOrderChargeMap1.put("subject", "微信h5订单");

        //订单2的Map
        Map<String, Object> merchOrderChargeMap2 = new HashMap<String, Object>();
        merchOrderChargeMap2.put("order_no", "order_no_22222");
        merchOrderChargeMap2.put("channel", "JD-WAP-PAY");
        merchOrderChargeMap2.put("currency", "cny");
        merchOrderChargeMap2.put("amount", 2);
        merchOrderChargeMap2.put("subject", "京东订单");

        //订单1、订单2都添加进去
        List<Map<String,Object>> merchOrderChargeMapList = new ArrayList<Map<String,Object>>();
        merchOrderChargeMapList.add(merchOrderChargeMap1);
        merchOrderChargeMapList.add(merchOrderChargeMap2);

        //List<MerchOrderCharge> merchOrderChargeList =  new ArrayList<MerchOrderCharge>();
        //List<MerchOrderCharge> merchOrderChargeListResult =
        List<MerchOrderCharge> resultList =	MapBeanUtil.mapsToObjects(merchOrderChargeMapList, MerchOrderCharge.class);

        for (MerchOrderCharge merchOrderCharge : resultList) {
            System.out.println(merchOrderCharge);
        }
    }

}