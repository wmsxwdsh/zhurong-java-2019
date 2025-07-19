/**
 * @Title: YesNoEnum.java
 * @Package: com.zhurong.utils.constenum
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.utils.ConstEnum;

/**
 * @description:
 * @author LZG
 * @date 2020年06月15日
 */
public enum YesNoEnum {

    YES(1),
    NO(0);

    private Integer value;

    YesNoEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

}