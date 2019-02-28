/**
 * @Title: TxtUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import com.zhurong.utils.json.JsonUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author LZG
 * @date 2019/2/28
 */
public class TxtUtil {

    // 缓冲区大小
    private final static int buffer_size = 1024;

    // 换行符
    @SuppressWarnings("restriction")
    private final static String lineSeparator = java.security.AccessController
        .doPrivileged(new sun.security.action.GetPropertyAction("line.separator"));


    /**
     * @Description: 读取txt文件
     * @param filePah txt文件路径
     * @return java.util.List<java.lang.Object [ ]>
     * @author LZG
     * @date 2019/1/18
     */
    public static List<String[]> readTxtFile(String filePah) throws Exception {
        List<String[]> resultList = new ArrayList<>();
        FileReader fr = new FileReader(filePah);
        BufferedReader bf = new BufferedReader(fr);
        String str;

        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            String[] rowArr = str.split(",");
            resultList.add(rowArr);
        }
        bf.close();
        fr.close();
        return resultList;
    }

    /**
     * @Description: 将数据集合以行的形式写入txt文件
     * @param rowsData 行数据List集合
     * @param filePath txt文件路径
     * @return void
     * @author LZG
     * @date 2019/2/1
     */
    public static synchronized void writeRows2TxtFile(List<String[]> rowsData, String filePath) throws Exception {
        // txt文件内容
        StringBuffer txtStr = new StringBuffer();

        // 拼接每一行
        for (int i = 0; i < rowsData.size(); i++) {
            // 拼接一行数据成字符串
            StringBuffer line = new StringBuffer();

            Object[] row = rowsData.get(i);
            for (int j = 0; j < row.length; j++) {
                String field = TxtUtil.formatField(row[j]);

                if (j == row.length - 1) {
                    line.append(field);
                } else {
                    line.append(field).append(",");
                }
            }

            // 将一行数据的字符串添加到结果集中
            if (i == rowsData.size() - 1) { // 最后一行,不用换行
                txtStr.append(line);
            } else {
                txtStr.append(line).append(lineSeparator);
            }
        }

        TxtUtil.writeString2SimpleFile(txtStr.toString(), filePath, "UTF-8");
    }


    /*----private method start-------------------------------------------------------------------*/

    /**
     * @Description: 以XXX字符编码将内容字符串写入txt文件里
     * @param str 要输出的字符串
     * @param filePath 简单文件的具体路径
     * @param charsetName UTF-8 | GB2312
     * @return void
     * @author LZG
     * @date 2019/1/18
     */
    private static void writeString2SimpleFile(String str, String filePath, String charsetName) throws Exception {

        BufferedWriter out = null;
        try {
            File file = new File(filePath);

            boolean firstResult = createNewFileIfNotExists(file);
            OutputStreamWriter os = null;
            if (firstResult) {
                os = new OutputStreamWriter(new FileOutputStream(file), charsetName);
            } else {
                os = new OutputStreamWriter(new FileOutputStream(file, true), charsetName);
            }
            out = new BufferedWriter(os, TxtUtil.buffer_size);

            if (!firstResult) {
                out.write("\r\n");
            }
            out.write(str);
            out.flush();

        } finally {
            TxtUtil.close(out);
        }

    }

    /**
     * @Description: 如果文件不存在, 创建一个新文件
     * @param file
     * @return boolean 第一次（创建），1次往后（追加）
     * @author LZG
     * @date 2019/1/18
     */
    private static boolean createNewFileIfNotExists(File file) throws IOException {
        if (!file.exists()) {
            // 创建目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 创建文件
            file.createNewFile();
            return true;
        }
        return false;
    }

    /**
     * @Description: 关闭输出流
     * @param out
     * @return void
     * @author LZG
     * @date 2019/1/18
     */
    private static void close(Writer out) {
        if (null != out) {
            try {
                out.close();
            } catch (IOException e) {
                // e.printStackTrace();
            }
        }
    }

    /**
     * @Description: 格式化一个field成标准格式字符串
     * @param field 支持接收的参数类型（支持扩展）
     * @return java.lang.String JSON字符串
     * @author LZG
     * @date 2019/2/1
     */
    private static String formatField(Object field) {
        // null时给一个空格占位
        if (null == field) {
            return " ";
        }
        Class clazz = field.getClass();

        // byte、short、integer、long
        if (clazz == byte.class || clazz == short.class || clazz == int.class || clazz == long.class
            || clazz == Byte.class || clazz == Short.class || clazz == Integer.class || clazz == Long.class) {
            return String.valueOf(field);
        }

        // boolean、char、String
        if (clazz == boolean.class || clazz == Boolean.class || clazz == char.class || clazz == Character.class
            || clazz == String.class) {
            return String.valueOf(field);
        }
        //阿里 fastjson
        //return JSON.toJSONString(field);
        return JsonUtil.objectToJson(field);
    }

    /*----private method end-------------------------------------------------------------------*/


    //测试
    public static void main(String[] args) throws Exception {

        List<String[]> rowsObject = new ArrayList<>();

        String[] row1 = new String[2];
        row1[0] = "1";
        row1[1] = "10";

        String[] row2 = new String[2];
        row2[0] = "2";
        row2[1] = "20";

        rowsObject.add(row1);
        rowsObject.add(row2);

        //写
        String filePath = "E:" + File.separator + "test" + File.separator + "world.txt";
        TxtUtil.writeRows2TxtFile(rowsObject, filePath);
        System.out.println("write success");

        //读
        List<String[]> resList = TxtUtil.readTxtFile(filePath);
        for(String[] element : resList) {
            System.out.println(Arrays.toString(element));
        }

    }

}