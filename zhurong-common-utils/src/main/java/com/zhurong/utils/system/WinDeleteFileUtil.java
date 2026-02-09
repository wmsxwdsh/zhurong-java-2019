package com.zhurong.utils.system;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * Windows源文件名长度大于文件系统支持的长度的文件删除工具类
 * -- 原文 <a href="https://blog.csdn.net/www_wangjun/article/details/73716011">...</a>
 * 2019/6/20
 */
public class WinDeleteFileUtil {

    //文件夹所嵌套的层数
    public static int totalSize;
    //计数器
    public static int count;
    //是否第一次进来文件夹
    public static boolean first = true;

    /**
     * 删除文件
     * @param folderPath
     */
    public static void handle(String folderPath) {
        long firstTime = System.currentTimeMillis();

        File file = new File(folderPath);
        try {
            while (true) {
                //初始化计数器
                count = 0;
                totalSize = totalSize - 199;

                //开始执行删除操作
                delAll(file);
                if (totalSize < 1) {
                    break;
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("总共耗时:" + ((endTime - firstTime) / 1000) + "秒");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件夹下所有内容，包括此文件夹删除文件夹下所有内容，包括此文件夹
     */
    private static void delAll(File f) throws IOException {
        File[] sub = f.listFiles();
        //如果是第一次进来
        if (first) {
            if (null != sub && sub.length > 0) {
                count++;
                delAll(sub[0]);
            } else {
                totalSize = count;
                first = false;
                System.out.println("===总共有" + totalSize + "层文件夹===");
            }
            //及时清空,否则会出现栈内存溢出StackOverflowError
            //sub = null;

        } else {
            if (sub.length > 0) {
                count++;
                if (totalSize - count < 100) {
                    FileUtils.deleteDirectory(f);
                    System.out.println(">>>还有" + (count - 1) + "层文件夹没有删除");
                } else {
                    delAll(sub[0]);
                }
            }
            //及时清空,否则会出现堆内存溢出
            //sub = null;
        }

    }

    //测试
    public static void main(String[] args) {
        String folderPath = "G:\\LZG\\中数资料";
        handle(folderPath);
    }

}