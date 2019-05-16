/**   
 * @Title: RegexUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.util.regex.Pattern;

/**
 * @description: 正则表达式工具类
 * @author LZG
 * @date 2018/8/24
 */
public class RegexUtil {

    private static final String EMAIL_REGEX  = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String IP_REGEX     = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final String URL_REGEX    = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private static final String IMAGE_REGEX = "(.*?)(?i)(jpg|jpeg|png|gif|bmp|webp)";

    /*手机号码*/
    private static final String MOBILE_REGEX = "^(13[0-9]|14[57]|15[012356789]|17[0678]|18[0-9])[0-9]{8}$";

    /*18位身份证号*/
    private static final String IDCARD18_REGEX = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$";
    /*15位身份证号*/
    private static final String IDCARD15_REGEX = "^[1-9]\\\\d{7}((0\\\\d)|(1[0-2]))(([0|1|2]\\\\d)|3[0-1])\\\\d{3}$";

    /*邮编*/
    private static final String POSTCODE_REGEX = "[1-9]\\d{5}";

    /*腾讯QQ号(腾讯QQ号从10000开始)*/
    private static final String QQ_REGEX = "[1-9][0-9]{4,}";


    /*空串(Blank characters, including: space、\t、\n、\r、\f、\x0B)*/
    private static final String BLANKSPACE_BLANK = "\\s+";
    /*中文*/
    private static final String CHINESE_REGEX = "^[\u4E00-\u9FA5]+$";
    /*纯数字*/
    private static final String NUM_REGEX = "^[0-9]*$";
    /*纯英文字母(包括大小写)*/
    private static final String LETTER_REGEX = "^[A-Za-z]+$";
    /*字母(包括大小写)+数字*/
    private static final String LETTER_NUM_REGEX = "^[A-Za-z0-9]+$";
    /*字母(包括大小写)+数字+下划线*/
    private static final String LETTER_NUM_UNDERLINE_REGEX = "^\\w+$";

    /* 密码1, 由大写字母、小写字母、数字、特殊字符的任意3种组成，8-32位*/
    private static final String PASSWORD_1_REGEX = "^(?![A-Za-z]+$)(?![A-Z\\d]+$)(?![A-Z\\W]+$)(?![a-z\\d]+$)(?![a-z\\W]+$)"
        + "(?![\\d\\W]+$)\\S{8,32}$";

    /**
     * @Description: 是否符合密码1的规则
     * @param str
     * @return boolean
     * @author LZG
     * @date 2019/5/16
     */
    public static boolean isPassword1(String str) {
        return isMatch(PASSWORD_1_REGEX, str);
    }

    /**
     * @Description: 是否为数字
     * @param str
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isNumber(String str) {
        return isMatch(NUM_REGEX, str);
    }

    /**
     * @Description: 是否为email
     * @param email zhangsan@xxx.com(xxx representative email service provider)
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isEmail(String email) {
        return isMatch(EMAIL_REGEX, email);
    }

    /**
     * @Description: 是否为18位有效的身份证号(推荐使用IdCardUtil.java)
     * @param idCard
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isIdCard18(String idCard) {
        return isMatch(IDCARD18_REGEX, idCard);
    }

    /**
     * @Description: 是否为15位有效的身份证号(推荐使用IdCardUtil.java)
     * @param idCard
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isIdCard15(String idCard) {
        return isMatch(IDCARD15_REGEX, idCard);
    }

    /**
     * @Description: 后缀是否为图片
     * @param suffix 一般是文件名
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isImage(String suffix) {
        if (null != suffix && !"".equals(suffix) && suffix.contains(".")) {
            return isMatch(IMAGE_REGEX, suffix);
        }
        return false;
    }

    /**
     * @Description: 是否为有效的手机号
     *       (support international format, +86135 XXXX... (mainland China), +00852137 XXXX... (Hong Kong, China)
     *        <p>Mobile(中国移动)：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188</p>
     *        <p>Unicom(中国联通)：130、131、132、145、155、156、171、175、176、185、186</p>
     *        <p>Chinanet(中国电信)：133、153、173、177、180、181、189</p>
     *        <p>Globalstar：1349</p>
     *        <p>VNO：170</p>
     * @param mobile
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isMobile(String mobile) {
        return isMatch(MOBILE_REGEX, mobile);
    }

    /**
     * @Description: 是否为空串
     * @param blankSpace
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isBlankSpace(String blankSpace) {
        return isMatch(BLANKSPACE_BLANK, blankSpace);
    }
 
    /**
     * @Description: 是否为中文
     * @param chinese
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isChinese(String chinese) {
        return isMatch(CHINESE_REGEX, chinese);
    }

    /**
     * @Description: 是否为url
     * @param url
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isURL(String url) {
        return isMatch(URL_REGEX, url);
    }

    /**
     * @Description: 是否为有效的中国邮政编码
     * @param postcode
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isPostcode(String postcode) {
        return isMatch(POSTCODE_REGEX, postcode);
    }

    /**
     * @Description: 是否为IP地址(只支持 IPV4 standard address)
     * @param ipAddress
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isIpAddress(String ipAddress) {
        return isMatch(IP_REGEX, ipAddress);
    }

    /**
     * @Description: 是否为字母(包括大小写)
     * @param inputStr
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isLetter(String inputStr) {
        return isMatch(LETTER_REGEX, inputStr);
    }

    /**
     * @Description: 是否为字母(包括大小写)+数字组成的字符串
     * @param inputStr
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isLetterNum(String inputStr) {
        return isMatch(LETTER_NUM_REGEX, inputStr);
    }

    /**
     * @Description: 是否为字母(包括大小写)+数字+下划线组成的字符串
     * @param inputStr
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isLetterNumUnderline(String inputStr) {
        return isMatch(LETTER_NUM_UNDERLINE_REGEX, inputStr);
    }

    /**
     * @Description: 是否为有效的qq号
     * @param qq
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    public static boolean isQQ(String qq) {
        return isMatch(QQ_REGEX, qq);
    }

    /**
     * @Description: 验证input是否能匹配上regex(建议该方法内部使用,不对外开放)
     * @param regex
     * @param input
     * @return boolean
     * @author LZG
     * @date 2018/8/24
     */
    private static boolean isMatch(final String regex, final String input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

}