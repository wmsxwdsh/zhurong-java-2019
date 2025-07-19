package com.zhurong.utils.common;

import cn.hutool.core.util.URLUtil;

/**
 * 可用于 Sub Convert
 */
public class EnhanceURLUtil {

    // url encode（编码）
    public static String encode(String url) {
        return URLUtil.encode(url);
    }

    // url decode（解码）
    public static String decode(String url) {
        return URLUtil.decode(url);
    }

    public static void main(String[] args) {
        // 解码
        String lastUrl = "";
        String firstUrl = decode(lastUrl);
        System.out.println(firstUrl);

        System.out.println("---------");

        // 生成编码
        String sourceUrl = "";
        String result = decode(sourceUrl);
        System.out.println(result);
    }

}

