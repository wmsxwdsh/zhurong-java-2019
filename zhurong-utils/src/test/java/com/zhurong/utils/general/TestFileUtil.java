/**
 * @Title: TestFileUtil.java
 * @Package: com.zhurong.utils.general
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.general;

import java.io.File;
import org.junit.Test;

/**
 * @description: FileUtil测试类
 * @author LZG
 * @date 2018/8/27
 */
public class TestFileUtil {

    //extName()方法测试
    @Test
    public void test1() {
        File file = new File("HelloWorld.jpg");
        String fileName = file.getName();
        System.out.println(FileUtil.extName(fileName));
    }

    //mkParentDirs(),只会创建所给文件父目录，并没有创建文件，顾名思义。
    @Test
    public void test2() {
        File file = new File("E:\\hello\\world\\张三.jpg");
        FileUtil.mkParentDirs(file);
    }

    //touch()方法,文件父目录和文件一块都创建了
    @Test
    public void test3() {
        File file = new File("E:\\hello\\world\\张三.jpg");
        FileUtil.touch(file);
    }

    //getFileSize()
    @Test
    public void test4() {
        String result = FileUtil.getFileSize("E:\\image\\1.jpg");
        System.out.println(result);
    }

    //delFile()
    @Test
    public void test5() {
        FileUtil.delFile("E://image//22.jpg");
    }

}