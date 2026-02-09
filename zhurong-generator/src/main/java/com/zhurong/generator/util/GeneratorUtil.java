package com.zhurong.generator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class GeneratorUtil {

    /**
     * 去掉下划线和把首字母转成大写
     * -- setter和getter方法时用到
     * -- 比如：create_time -> CreateTime -> setCreateTime/getCreateTime
     */
    public static String toUpperCase(String str) {
        //防止数据库表字段名称本来就全是大写
        str = str.toLowerCase();

        String result = replaceUnderLine(str);
        return StringUtils.capitalize(result);
    }

    /**
     * 去除下划线，并且下划线后面的字母变成大写（本身是大写则不变）
     */
    public static String replaceUnderLine(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");

        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                if(Character.isUpperCase(ss))
                    continue;

                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return result;
    }

    /**
     * 将包名转换成路径
     */
    public static String package2path(String packagePath) {
        return packagePath.replaceAll("\\.", "\\\\");
    }

    /**
     * 将大写字母转换为下划线
     */
    public static String upperCharToUnderLine(String param) {

        Pattern p = Pattern.compile("[A-Z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }


}