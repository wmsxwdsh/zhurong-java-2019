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
 * Created on 2017年4月20日 上午12:38:35
 * @author LZG (mailto:liuzhongguochn@gmail.com)
 * 功能说明：
 * 将别人写的工程导入Eclipse里的时候，java文件出现了乱码。
 * 因为工程的原始编码是GBK的，不是UTF-8编码，结果就会出现中文乱码的情况。
 *******************************************************************/
public class ConvertEncoding {

    public static void main(String[] args) throws Exception {
//		String srcDir = "F:\\mars2project\\PoiDemo\\src";
        String srcDir = "F:\\MainProject\\waimai2\\src";

        List<String> files = new ArrayList<String>();

        //fetchFileList(srcDir, files, ".properties");
        fetchFileList(srcDir, files, ".java");

        for (String fileName : files) {
            //convert(fileName, "GB2312", fileName, "UTF-8");
            convert(fileName, "GBK", fileName, "UTF-8");
            //convert(fileName, "windows-1252", fileName, "UTF-8");
        }
    }

    public static void convert(String oldFile, String oldCharset, String newFlie, String newCharset) {
        BufferedReader bin;
        FileOutputStream fos;
        StringBuffer content = new StringBuffer();
        try {
            System.out.println(oldFile);
            bin = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile), oldCharset));
            String line = null;
            while ((line = bin.readLine()) != null) {
                //System.out.println("content:" + content);
                content.append(line);
                content.append(System.getProperty("line.separator"));
            }
            bin.close();
            File dir = new File(newFlie.substring(0, newFlie.lastIndexOf("\\")));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            fos = new FileOutputStream(newFlie);
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

    public static void fetchFileList(String strPath, List<String> filelist, final String regex) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        Pattern p = Pattern.compile(regex);
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                fetchFileList(files[i].getAbsolutePath(), filelist, regex);
            } else {
                String strFileName = files[i].getAbsolutePath().toLowerCase();
                Matcher m = p.matcher(strFileName);
                if (m.find()) {
                    filelist.add(strFileName);
                }
            }
        }
    }

}
