package com.zhurong.utils.TheOthers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 敏感词过滤工具类
 * 2018/11/15
 */
public class SensitiveWordUtil {

    //敏感词词库路径
    private static final String SENSITIVE_WORD_PATH = "/config/sensitive_word.txt";

    /**
     * 敏感词匹配规则
     */
    //最小匹配规则，如：敏感词库["中国","中国人"]，语句："我是中国人"，匹配结果：我是[中国]人
    public static final int MinMatchTYpe = 1;
    //最大匹配规则，如：敏感词库["中国","中国人"]，语句："我是中国人"，匹配结果：我是[中国人]
    public static final int MaxMatchType = 10;

    /**
     * 敏感词集合
     */
    public static HashMap sensitiveWordMap;

    /**
     * 初始化敏感词库，构建DFA算法模型
     * @param sensitiveWordSet 敏感词库
     */
    public static synchronized void init(Set<String> sensitiveWordSet) {
        initSensitiveWordMap(sensitiveWordSet);
    }

    /**
     * 初始化敏感词库，构建DFA算法模型
     * @param sensitiveWordSet 敏感词库
     */
    private static void initSensitiveWordMap(Set<String> sensitiveWordSet) {
        //初始化敏感词容器，减少扩容操作
        sensitiveWordMap = new HashMap(sensitiveWordSet.size());
        String key;
        Map nowMap;
        Map<String, String> newWorMap;
        //迭代sensitiveWordSet
        Iterator<String> iterator = sensitiveWordSet.iterator();
        while (iterator.hasNext()) {
            //关键字
            key = iterator.next();
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                //转换成char型
                char keyChar = key.charAt(i);
                //库中获取关键字
                Object wordMap = nowMap.get(keyChar);
                //如果存在该key，直接赋值，用于下一个循环获取
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<>();
                    //不是最后一个
                    newWorMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    //最后一个
                    nowMap.put("isEnd", "1");
                }
            }
        }
    }

    /**
     * 判断文字是否包含敏感字符
     * @param txt       文字
     * @param matchType 匹配规则 1：最小匹配规则，2：最大匹配规则
     * @return 若包含返回true，否则返回false
     */
    public static boolean contains(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            //判断是否包含敏感字符
            int matchFlag = checkSensitiveWord(txt, i, matchType);
            //大于0存在，返回true
            if (matchFlag > 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取文字中的敏感词
     * @param txt       文字
     * @param matchType 匹配规则 1：最小匹配规则，2：最大匹配规则
     */
    public static Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet<>();

        for (int i = 0; i < txt.length(); i++) {
            //判断是否包含敏感字符
            int length = checkSensitiveWord(txt, i, matchType);
            if (length > 0) {//存在,加入list中
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;//减1的原因，是因为for会自增
            }
        }

        return sensitiveWordList;
    }

    /**
     * 替换敏感字字符
     * @param txt         文本
     * @param replaceChar 替换的字符，匹配的敏感词以字符逐个替换，如 语句：我爱中国人 敏感词：中国人，替换字符：*， 替换结果：我爱***
     * @param matchType   敏感词匹配规则
     */
    public static String replaceSensitiveWord(String txt, char replaceChar, int matchType) {
        String resultTxt = txt;
        //获取所有的敏感词
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word;
        String replaceString;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }

        return resultTxt;
    }

    /**
     * 获取替换字符串
     * @param replaceChar
     * @param length
     */
    private static String getReplaceChars(char replaceChar, int length) {
        String resultReplace = String.valueOf(replaceChar);
        for (int i = 1; i < length; i++) {
            resultReplace += replaceChar;
        }

        return resultReplace;
    }

    /**
     * 检查文字中是否包含敏感字符，检查规则如下：<br>
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return 如果存在，则返回敏感词字符的长度，不存在返回0
     */
    private static int checkSensitiveWord(String txt, int beginIndex, int matchType) {
        //敏感词结束标识位：用于敏感词只有1位的情况
        boolean flag = false;
        //匹配标识数默认为0
        int matchFlag = 0;
        char word;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            //获取指定key
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {//存在，则判断是否为最后一个
                //找到相应key，匹配标识+1
                matchFlag++;
                //如果为最后一个匹配规则,结束循环，返回匹配标识数
                if ("1".equals(nowMap.get("isEnd"))) {
                    //结束标志位为true
                    flag = true;
                    //最小规则，直接返回,最大规则还需继续查找
                    if (MinMatchTYpe == matchType) {
                        break;
                    }
                }
            } else {//不存在，直接返回
                break;
            }
        }
        if (matchFlag < 2 || !flag) {//长度必须大于等于1，为词
            matchFlag = 0;
        }
        return matchFlag;
    }

    /**
     * 校验是否存在敏感词
     * @return 存的敏感词集合
     */
    public static Set<String> checkSensitiveWord(String content) {
        String fileName = SENSITIVE_WORD_PATH;
        Set<String> set = null;
        try {
            File file = new File(SensitiveWordUtil.class.getResource(fileName).getFile());
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = br.readLine();//读取文件内容
            String[] lines = line.split("，");//创建一个String数组以，分隔内容
            //String[] 转List<String> ,List<String> 再转为Set过滤重复内容
            List<String> ss = Arrays.asList(lines);
            Set<String> sensitiveWordSet = new HashSet<String>(ss);
            //初始化敏感词库
            SensitiveWordUtil.init(sensitiveWordSet);
            System.out.println("敏感词的数量：" + sensitiveWordSet.size());
            //是否含有关键字
            boolean result = SensitiveWordUtil.contains(content, SensitiveWordUtil.MinMatchTYpe);
            System.out.println(result);
            //获取语句中的敏感词
            set = SensitiveWordUtil.getSensitiveWord(content, SensitiveWordUtil.MinMatchTYpe);
            System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }


    // 测试一下
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String fileName = SENSITIVE_WORD_PATH; //敏感词地址

        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try {
            File file = new File(SensitiveWordUtil.class.getResource(fileName).getFile());
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = br.readLine();
            String[] lines = line.split("，");
            List<String> ss = Arrays.asList(lines);
            Set<String> sensitiveWordSet = new HashSet<String>(ss);
            //初始化敏感词库
            SensitiveWordUtil.init(sensitiveWordSet);
            System.out.println("敏感词的数量：" + sensitiveWordSet.size());
            String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节。" + "然后我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
                + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个贱人一杯红酒一部电影在夜 深人静的晚上，关上电话静静的发呆着。";
            System.out.println("待检测语句字数：" + string.length());
            //是否含有关键字
            boolean result = SensitiveWordUtil.contains(string, SensitiveWordUtil.MinMatchTYpe);
            System.out.println("是否含有敏感词：" + result);

            //获取语句中的敏感词
            Set<String> set = SensitiveWordUtil.getSensitiveWord(string, SensitiveWordUtil.MinMatchTYpe);
            System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
            //替换语句中的敏感词
            String filterStr = SensitiveWordUtil.replaceSensitiveWord(string, '*', SensitiveWordUtil.MinMatchTYpe);
            System.out.println("屏蔽敏感词后语句如下：");
            System.out.println(filterStr);
            long endTime = System.currentTimeMillis();
            System.out.println("花费总耗时：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
