/**   
 * @Title: BizType.java
 * @Package: com.zhurong.jdk.enumTest
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.jdk.enumTest;

/**
 * @description: 记账业务类型
 * @author LZG
 * @date 2018/10/24
 */
public enum BizType {

    GRAB_COIN("01", "抢金币"),
    SETTLEMENT_REVENUE("02", "结算收益"),
    INCOME_TRANSFER_BALANCE("03", "收益转余额"),
    BUY_AD("04", "购买广告位"),
    BUY_CITY("05", "购买主城"),
    AD_REVENUE("06", "广告位收益"),
    INVITE_LANDLORD_REVENUE("07", "邀请城主收益"),
    TENANT_COIN_REVENUE("08", "居民资讯红包收益"),
    TRIBAL_MEMBER_REVENUE("09", "部落成员收益"),
    SYSTEM_USER_REVENUE("10", "系统用户收益"),
    USER_WITHDRAW("11", "用户提现"),
    OTHERS_REVENUE("12", "其他收益");

    private String name;
    private String value;

    private BizType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static BizType getByValue(String value) {
        for (BizType bizType : values()) {
            if (bizType.getValue().equals(value)) {
                return bizType;
            }
        }
        return null;

    }

}