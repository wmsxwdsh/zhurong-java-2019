package com.zhurong.solution.project2utf8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*******************************************************************
 * 功能说明：
 * 将别人写的工程导入Eclipse里的时候，java文件出现了乱码。
 * 因为工程的原始编码是GBK的，不是UTF-8编码，结果就会出现中文乱码的情况。
 *******************************************************************/
public class ConvertEncoding {

    public static void main(String[] args) throws Exception {
        String srcDir = "F:\\MainProject\\waimai2\\src";

        List<String> fileNameList = new ArrayList<String>();

        //fetchFileList(srcDir, fileNameList, ".properties");
        fetchFileList(srcDir, fileNameList, ".java");

        for (String fileName : fileNameList) {
            //convert(fileName, "GB2312", fileName, "UTF-8");
            convert(fileName, "GBK", fileName, "UTF-8");
        }
    }

    public static void convert(String oldFile, String oldCharset, String newFile, String newCharset) {
        BufferedReader bin;
        FileOutputStream fos;
        StringBuffer content = new StringBuffer();
        try {
            System.out.println(oldFile);
            bin = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile), oldCharset));
            String line;
            while ((line = bin.readLine()) != null) {
                //System.out.println("content:" + content);
                content.append(line);
                content.append(System.getProperty("line.separator"));
            }
            bin.close();
            File dir = new File(newFile.substring(0, newFile.lastIndexOf("\\")));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            fos = new FileOutputStream(newFile);
            Writer out = new OutputStreamWriter(fos, newCharset);
            out.write(content.toString());
            out.close();
            fos.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件列表
     * @param srcPath 根文件夹路径
     * @param fileList 文件集合
     * @param regex 正则匹配
     */
    public static void fetchFileList(String srcPath, List<String> fileList, final String regex) {
        File dir = new File(srcPath);
        File[] files = dir.listFiles();
        Pattern p = Pattern.compile(regex);

        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                fetchFileList(files[i].getAbsolutePath(), fileList, regex);
            } else {
                String strFileName = files[i].getAbsolutePath().toLowerCase();
                Matcher m = p.matcher(strFileName);
                if (m.find()) {
                    fileList.add(strFileName);
                }
            }
        }
    }

}
