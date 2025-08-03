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
        String lastUrl = "https://pub-api-1.bianyuan.xyz/sub?config=https%3A%2F%2Fraw.githubusercontent.com%2Fwmsxwdsh%2FClashSub%2Fmain%2Fwmsxwdsh20230715.ini&emoji=true&fdn=false&insert=false&list=false&scv=false&sort=false&target=surge&tfo=false&url=https%3A%2F%2Fhuaikhwang.central-world.org%2Fapi%2Fv1%2Ftrails%2Fbolster%3Ftoken%3D347657d1b4674ee164d7634ca1727304&ver=4";
        String firstUrl = decode(lastUrl);
        System.out.println(firstUrl);

        System.out.println("---------");

        // 生成编码
        String sourceUrl = "";
        String result = decode(sourceUrl);
        System.out.println(result);
    }

}

