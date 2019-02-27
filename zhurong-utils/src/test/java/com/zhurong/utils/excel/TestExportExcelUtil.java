/**
 * @Title: TestExportExcelUtil.java
 * @Package: com.zhurong.utils.excel
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.excel;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @description: ExportExcelUtil测试
 * @author LZG
 * @date 2018/11/13
 */
public class TestExportExcelUtil {

    @Test
    public void test1() throws Exception {
        ExportExcelUtil<Student> util = new ExportExcelUtil<Student>();

        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Student(111, "张三asdf", "男"));
            list.add(new Student(111, "李四asd", "男"));
            list.add(new Student(111, "王五", "女"));
        }

        String[] columnNames = {"ID", "姓名", "性别"};

        //util.exportExcel("用户导出", columnNames, list, new FileOutputStream("E:/test.xls"),ExportExcelUtil.EXCEL_FILE_2003);

        util.exportExcel("用户导出", columnNames, list, new FileOutputStream("E:/test.xlsx"), ExportExcelUtil.EXCEl_FILE_2007);
    }

}