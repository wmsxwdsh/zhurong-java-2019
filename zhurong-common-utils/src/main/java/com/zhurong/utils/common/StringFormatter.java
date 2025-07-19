package com.zhurong.utils.common;

/**
 * 字符串格式化输出工具类
 * @date 2018/8/24
 */
public class StringFormatter {

    /**
     * 格式化字符串
     *      此方法只是简单将占位符 {} 按照顺序替换为参数
     *      如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可
     *      例：
     *      通常使用：format("this is {} for {}", "a", "b") =》 this is a for b
     *      转义{}： format("this is \\{} for {}", "a", "b") =》 this is {} for a
     *      转义\：		format("this is \\\\{} for {}", "a", "b") =》 this is \a for b
     * @date 2018/8/24
     */
    public static String format(final String strPattern, final String... argArray) {
        if (StringUtil.isBlank(strPattern) ) {
            return strPattern;
        }
        if(argArray == null || argArray.length == 0)
            return strPattern;

        final int strPatternLength = strPattern.length();

        //初始化定义好的长度以获得更好的性能
        StringBuilder sbuf = new StringBuilder(strPatternLength + 50);

        int handledPosition = 0; //记录已经处理到的位置
        int delimIndex; //占位符所在位置
        for (int argIndex = 0; argIndex < argArray.length; argIndex++) {
            delimIndex = strPattern.indexOf("{}", handledPosition);
            if (delimIndex == -1) {//剩余部分无占位符
                if (handledPosition == 0) { //不带占位符的模板直接返回
                    return strPattern;
                } else { //字符串模板剩余部分不再包含占位符，加入剩余部分后返回结果
                    sbuf.append(strPattern, handledPosition, strPatternLength);
                    return sbuf.toString();
                }
            } else {
                if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == '\\') {//转义符
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == '\\') {//双转义符
                        //转义符之前还有一个转义符，占位符依旧有效
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(argArray[argIndex]);
                        handledPosition = delimIndex + 2;
                    } else {
                        //占位符被转义
                        argIndex--;
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append('{');
                        handledPosition = delimIndex + 1;
                    }
                } else {//正常占位符
                    sbuf.append(strPattern, handledPosition, delimIndex);
                    sbuf.append(argArray[argIndex]);
                    handledPosition = delimIndex + 2;
                }
            }
        }
        
        sbuf.append(strPattern, handledPosition, strPattern.length());

        return sbuf.toString();
    }


    // 测试一下
    public static void main(String[] args) {

        System.out.println(StringFormatter.format("my name is {}, his name is {}.", "叶孤城", "西门吹雪"));
        System.out.println(StringFormatter.format("my name is \\{}.", "陆小凤"));
        System.out.println(StringFormatter.format("my name is \\\\{}.", "花满楼"));

    }

}