package com.zhurong.utils.algorithm;

import java.io.File;

/**
 * 递归算法
 * @date 2019/2/28
 */
public class Recursive {

    public static void readFiles(File file) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(int i = 0; i < files.length; i++) {
                if(files[i].isDirectory()) {
                    readFiles(files[i]);
                }
                System.out.println(files[i].getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        //这里使用反斜杠，windows和linux都认识。
        File file = new File("G:/电影");
        readFiles(file);
    }
}