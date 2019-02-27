/**
 * @Title: PinyinUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.nio.charset.Charset;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @description: 拼音工具类
 * @author LZG
 * @date 2018/8/24
 */
public class PinyinUtil {

    /**
     * @Description: 获取中文字符串的字母字符串
     * @param chinese 中文字符串
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/24
     */
    public static String getAllLetter(String chinese) {

        if (StringUtil.isBlank(chinese))
            throw new RuntimeException("chinese不能为空.");

        char[] chinese_chars = chinese.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE); // 输出拼音全部小写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE); // 不带声调
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

        try {
            for (int i = 0; i < chinese_chars.length; i++) {

                //如果字符是中文,则将中文转为汉语拼音
                if (String.valueOf(chinese_chars[i]).matches("[\u4e00-\u9fa5]+")) {
                    hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(chinese_chars[i], defaultFormat)[0];
                } else {
                    //如果字符不是中文,则不转换
                    //hanyupinyin += chinese_chars[i];
                    throw new RuntimeException("chinese不是中文字符.");
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        return hanyupinyin;
    }


    /**
     * @Description: 获取中文的首字母. 例：刘德华 -- ldh
     * @param chinese 中文字符串
     * @return java.lang.String
     * @author LZG
     * @date 2018/8/24
     */
    public static String getAllFirstLetter(String chinese) {
        if (StringUtil.isBlank(chinese))
            throw new RuntimeException("chinese不能为空");

        int len = chinese.length();
        StringBuilder strBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            strBuilder.append(getFirstLetter(chinese.charAt(i)));
        }

        return strBuilder.toString();
    }

    /**
     * @Description: 获取拼音首字母
     *              传入汉字，返回拼音首字母
     *              如果传入字母，返回其小写形式
     * @param ch
     * @return char 首字母，小写
     * @author LZG
     * @date 2018/8/24
     */
    private static char getFirstLetter(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return Character.toLowerCase(ch);
        }
        final byte[] bys = String.valueOf(ch).getBytes(Charset.forName("GBK"));
        if (bys.length == 1) {
            return '*';
        }
        int count = (bys[0] + 256) * 256 + bys[1] + 256;
        if (count < 45217) {
            return '*';
        } else if (count < 45253) {
            return 'a';
        } else if (count < 45761) {
            return 'b';
        } else if (count < 46318) {
            return 'c';
        } else if (count < 46826) {
            return 'd';
        } else if (count < 47010) {
            return 'e';
        } else if (count < 47297) {
            return 'f';
        } else if (count < 47614) {
            return 'g';
        } else if (count < 48119) {
            return 'h';
        } else if (count < 49062) {
            return 'j';
        } else if (count < 49324) {
            return 'k';
        } else if (count < 49896) {
            return 'l';
        } else if (count < 50371) {
            return 'm';
        } else if (count < 50614) {
            return 'n';
        } else if (count < 50622) {
            return 'o';
        } else if (count < 50906) {
            return 'p';
        } else if (count < 51387) {
            return 'q';
        } else if (count < 51446) {
            return 'r';
        } else if (count < 52218) {
            return 's';
        } else if (count < 52698) {
            return 't';
        } else if (count < 52980) {
            return 'w';
        } else if (count < 53689) {
            return 'x';
        } else if (count < 54481) {
            return 'y';
        } else if (count < 55290) {
            return 'z';
        }
        return ' ';
    }

}