package com.zhurong.utils.content;

import cn.hutool.core.util.DesensitizedUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 脱敏工具
 * 更推荐使用 Hutool 提供的脱敏工具类 DesensitizedUtil
 */
public class MaskUtil {

    /**
     * 身份证号脱敏
     * @param cardNum :
     * @return : java.lang.String
     */
    public static String iDCardDesensitization(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * 手机号脱敏
     * @param phone :
     * @return : java.lang.String
     */
    public static String phoneDesensitization(String phone) {
        if (StringUtils.isBlank(phone)) {
            return "";
        }
        return StringUtils.left(phone, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(phone, 4), StringUtils.length(phone), "*"), "***"));
    }

    /**
     * 银行卡脱敏
     * @param cardNum :
     * @return : java.lang.String
     */
    public static String bankCardDesensitization(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }


    public static void main(String[] args) {
        //身份证号脱敏测试
        print(MaskUtil.iDCardDesensitization("511402199104096753"));
        //手机号脱敏
        print(MaskUtil.phoneDesensitization("18911387565"));
        //银行卡号脱敏
        print(MaskUtil.bankCardDesensitization("6217000034560370678"));

        print("--------------------------------");

        // Hutool脱敏
        print(DesensitizedUtil.chineseName("李凯华"));
        print(DesensitizedUtil.idCardNum("511402199104096753", 1, 4));
        print(DesensitizedUtil.email("635555803@qq.com"));
    }

    public static void print(String str) {
        System.out.println(str);
    }

}